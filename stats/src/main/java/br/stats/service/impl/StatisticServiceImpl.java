package br.stats.service.impl;

import org.springframework.stereotype.Controller;

import br.stats.model.Statistic;
import br.stats.service.StatisticService;

public class StatisticServiceImpl implements StatisticService {

	public Statistic getStatistic() {
		return new Statistic();
	};

}
