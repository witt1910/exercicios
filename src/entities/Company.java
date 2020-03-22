package entities;

public class Company extends TaxPayer {

	private int numberOfEmployees;

	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, int numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numbverOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		double tax = 0.0;
		if (numberOfEmployees > 10) {
			tax = anualIncome * 0.14;
		} else {
			tax = anualIncome * 0.16;
		}
		return tax;
	}
}
