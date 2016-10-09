package com.project.ejb.data;


import java.util.Date;

public class Car {
	private String number;
	private String marka;
	private Date come;

	public Car(String number, String marka) {
		this.number = number;
		this.marka = marka;
		this.come = new Date();
	}

	Car() {
		this("", "");
	}

	public String getMarka() {
		return marka;
	}

	public String getNumber() {
		return number;
	}

	public Date getCome() { return come; }

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
