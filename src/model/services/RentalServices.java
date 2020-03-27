package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalServices {

	private Double pricePerHour;
	private Double pricePerDay;

	private TaxService taxService;

	public RentalServices() {
	}

	public RentalServices(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double) (t2 - t1) / 1000 / 60 / 60;

		double basicPayment;
		if (hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours); 
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours/24);
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
