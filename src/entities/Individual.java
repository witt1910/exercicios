package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		double tax = 0.0;
		if (anualIncome < 20000.00) {
			tax = anualIncome * 0.15;
		} else {
			tax = anualIncome * 0.25;
		}
		if (healthExpenditures > 0.0) {
			tax -= healthExpenditures * 0.5;
		}
		return tax;
	}
}
