package br.stats.service.impl;


import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;

import br.stats.model.Transaction;
import br.stats.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	public SortedMap<Long,Double> transactions = new TreeMap<>();
	
	public void addTransaction(Transaction json) {
		transactions.put(json.getTimestamp(), json.getAmount());
	}	
}
