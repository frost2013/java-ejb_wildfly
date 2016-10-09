package com.project.ejb.model;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.Date;

@Singleton
public class Finance {
	private int finance;
	private int minimumRate;

	@PostConstruct
	public void init() {
		finance = 0;
		minimumRate = 100;
	}

	public int getFinance() {
		return finance;
	}

	public void addFinance(int money) {
		if (money > 0) {
			finance += money;
		}
	}

	public void addFinance(Date coming) {
		int money = getProceedByCar(coming);
		addFinance(money);
	}

	public int getProceedByCar(Date coming) {
		double milliseconds = (new Date().getTime() - coming.getTime());
		double hour = (1000 * 60 * 60);

		return ((int) Math.ceil((milliseconds / hour)) ) * getRate();
	}

	public int getRate() {
		return minimumRate;
	}
}
