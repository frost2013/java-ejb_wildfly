package com.project.ejb.services;


import com.project.ejb.data.Car;
import com.project.ejb.model.CarManipulate;
import com.project.ejb.model.Finance;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("car")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class CarService {
	@EJB
	private CarManipulate carStorage;
	@EJB
	private Finance finance;

	@GET
	public List<Car> getAllCars() {
		return carStorage.getCars();
	}

	@PUT
	public String pushCar(@QueryParam("number") String number,
	                      @QueryParam("marka") String marka) {
        return carStorage.addCar(number, marka);
	}

	@DELETE
	public String removeCar(@QueryParam("number") String number,
	                        @QueryParam("marka") String marka) {
		Car removingCar = carStorage.getCar(number, marka);
		if (removingCar != null) {
			finance.addFinance(removingCar.getCome());
			carStorage.removeCar(removingCar);

			return "success: Car removed";
		}
		else {
			return "error: Error in removing";
		}
	}

	@GET
	@Path("/free")
	public int getFreeStorage() {
		return carStorage.getFreeStorage();
	}

	@GET
	@Path("/count")
	public int countCars() {
		return carStorage.getCountCars();
	}
}
