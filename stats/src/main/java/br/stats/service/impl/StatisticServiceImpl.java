package br.stats.service.impl;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import br.stats.model.Statistic;
import br.stats.model.Transaction;
import br.stats.service.StatisticService;
import br.stats.utils.DateUtil;

@EnableScheduling
@Service
public class StatisticServiceImpl implements StatisticService {
	
	public final Long INTERVAL = 60l;
		
	private Queue<Long> statisticsTime;
	private Map<Long, Statistic> statistics;
	
	StatisticServiceImpl(){
		statisticsTime = new PriorityBlockingQueue<Long>();
		statistics = new ConcurrentHashMap<Long, Statistic>();;
	}
		
	@Scheduled(fixedDelay = 10000)
	private void recicle() {
		Long now = DateUtil.converToTimeStamp(LocalDateTime.now());
		if (this.statisticsTime.isEmpty() || this.statisticsTime.peek() >= now)
			return;
		
		while(!this.statisticsTime.isEmpty() && this.statisticsTime.peek() < now) {
			Long key = this.statisticsTime.poll();
			this.statistics.remove(key);
		}
	}
	
	@Override
	public void addStatistic(Transaction transaction) throws Exception {
		Long now = DateUtil.converToTimeStamp(LocalDateTime.now());
		Long transactionTime = transaction.getTimestamp();
		
		if (transactionTime + INTERVAL < now) throw new Exception();
		
		for(Long i = now; i < transactionTime + INTERVAL; i+=1000) {
			Statistic statistic = this.statistics.get(i);
			if (statistic == null) {
				statistic = new Statistic();
				this.statistics.put(i, statistic);
				this.statisticsTime.add(i);
			}

			if (transaction.getAmount() > statistic.getMax())
				statistic.setMax(transaction.getAmount());
			if (transaction.getAmount() < statistic.getMin())
				statistic.setMin(transaction.getAmount());
			
			statistic.setSum(statistic.getSum() + transaction.getAmount());
			statistic.setCount(statistic.getCount()+1);
			statistic.setAvg(statistic.getSum()/statistic.getCount());
		}
	}
	
	@Override
	public Statistic getStatistic() {
		Long now = DateUtil.converToTimeStamp(LocalDateTime.now());
		Statistic statistic = this.statistics.get(now);
		if (statistic == null) 
			statistic = new Statistic();
		
		return statistic;
	}
}
