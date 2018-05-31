package br.stats.service;

import br.stats.model.Transaction;
import br.stats.model.TransactionJson;

public interface TransactionService {
	public void addTransaction(TransactionJson json) throws Exception;

}
