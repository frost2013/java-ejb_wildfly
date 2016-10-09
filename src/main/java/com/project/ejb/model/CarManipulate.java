package com.project.ejb.model;

import com.project.ejb.data.Car;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CarManipulate {
	private int maxStorage = 10;
	private ArrayList<Car> cars;

	@PostConstruct
	public void init() {
		cars = new ArrayList<Car>();
	}

	@PreDestroy
	public void quit() {
		cars.clear();
	}

	public List<Car> getCars() {
		return cars;
	}

	public String addCar(String number, String marka){
		if (number == null || marka == null) {
			return "error: Parameter is null";
		}
		if (number.equals("") || marka.equals("")) {
			return "error: Information about car is not full";
		}
		if (this.notBusy()) {
			Car newCar = new Car(number, marka);

			if (cars.contains(newCar)) {
				return "error: Already exist";
			}
			else {
				cars.add(newCar);
				return "success: Car added";
			}
		}
		else {
			return "error: Car storage is busy";
		}

	}

	public void removeCar(Car removingCar) {
		cars.remove(removingCar);
	}

	public void removeCar(String number, String marka) {
		Car removingCar = getCar(number, marka);

		if (removingCar != null) {
			removeCar(removingCar);
		}
	}

	public int getCountCars() {
		return this.cars.size();
	}

	public int getFreeStorage() {
		return this.maxStorage - getCountCars();
	}

	public boolean hasCars() {
		return getCountCars() > 0;
	}

	public boolean notBusy() {
		return getCountCars() < this.maxStorage;
	}

	public Car getCar(String number, String marka){
		if (this.hasCars()) {
			String searchString = (number.equals("") ? number : marka);

			for (int iter = 0; iter < this.getCountCars(); iter++) {
				if (cars.get(iter).getNumber().equals(searchString) ||
						cars.get(iter).getMarka().equals(searchString)) {
					return cars.get(iter);
				}
			}
		}

		return null;
	}

	private int searchCar(String number, String marka) {
		Car searching = getCar(number, marka);

		return (searching != null ? cars.indexOf(searching) : -1);
	}
}
