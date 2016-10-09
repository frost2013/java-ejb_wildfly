package com.project.ejb.services;

import com.project.ejb.data.Car;
import com.project.ejb.model.CarManipulate;
import com.project.ejb.model.Finance;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless(name="finance")
@Path("/finance")
public class FinancyService {
	@EJB
	private CarManipulate carStorage;
	@EJB
	private Finance finance;

	@GET
	public int getCurrentFinance() {
		return finance.getFinance();
	}

	@GET
	@Path("/car")
	public int getProceeds(@QueryParam("number") String number,
	                       @QueryParam("marka") String marka){
		Car searching = carStorage.getCar(number, marka);

		return finance.getProceedByCar(searching.getCome());
	}
}
