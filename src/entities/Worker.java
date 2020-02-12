package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double salary;

	private Department department;
	private List<HourContract> list = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, double salary, Department department) {
		this.name = name;
		this.level = level;
		this.salary = salary;
		this.department = department;
	}

	public void addContract(HourContract contract) {
		list.add(contract);
	}

	public void removeContract(HourContract contract) {
		list.remove(contract);
	}

	public double income(int year, int month) {
		double sum = salary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : list) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

	public String getName() {
		return name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public double getSalary() {
		return salary;
	}

	public Department getDepartment() {
		return department;
	}

}
