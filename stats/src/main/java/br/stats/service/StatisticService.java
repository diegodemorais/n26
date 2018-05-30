package br.stats.service;

import br.stats.model.Statistic;
import br.stats.model.Transaction;

public interface StatisticService {
	public void addStatistic(Transaction transaction) throws Exception;
	public Statistic getStatistic();

}
