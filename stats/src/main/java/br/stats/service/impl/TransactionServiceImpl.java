package br.stats.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.stats.model.Transaction;
import br.stats.service.StatisticService;
import br.stats.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	StatisticService statisticService;
	
	@Override
	public void addTransaction(Transaction json) throws Exception {
		statisticService.addStatistic(json);
	}	
	
}
