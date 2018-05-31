package br.stats.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.stats.model.Transaction;
import br.stats.model.TransactionJson;
import br.stats.service.StatisticService;
import br.stats.service.TransactionService;
import br.stats.utils.DateUtil;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	StatisticService statisticService;
	
	@Override
	public void addTransaction(TransactionJson json) throws Exception {
		Transaction transaction = new Transaction();
		transaction.setAmount(json.getAmount());
		transaction.setDate(DateUtil.convertToLocalDateTime(json.getTimestamp()));
		statisticService.addStatistic(transaction);
	}	
	
}
