package com.project.ejb.remote;

import com.project.ejb.data.Car;

import javax.ejb.Remote;
import javax.ws.rs.QueryParam;
import java.util.List;

public interface CarServiceRemote extends Remote {
	public List<Car> getAllCars();

	public String pushCar(@QueryParam("number") String number,
	                      @QueryParam("marka") String marka);

	public String removeCar(@QueryParam("number") String number,
	                        @QueryParam("marka") String marka);

	public int getFreeStorage();

	public int countCars();
}
