package employee;

import java.text.DecimalFormat;

public abstract class Employee {
	private String id;
	private String name;
	private String position;
	private double daySalary;
	private int workDays;
	
	public Employee (String id, String name, String position, double daySalary, int workDays) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.daySalary = daySalary;
		this.workDays = workDays;
	}
	
	public Employee () {
	}
	
	public static void displayHeader () {
		displaySeparator();
		System.out.printf(
			"| %10s | %-25s | %-15s | %10s | %10s | %10s |\n",
			"ID", "NAME", "POSITION", "DAY SALARY", "WORK DAYS", "SALARY"
		);
		displaySeparator();
	}
	
	public static void displaySeparator () {
		System.out.printf(
			"+-%-10s-+-%-25s-+-%-15s-+-%-10s-+-%-10s-+-%-10s-+ %n",
			"----------", "-------------------------", "---------------", "----------", "----------", "----------"
		);
	}
	
	public String getId () {
		return id;
	}
	
	public void setId (String id) {
		this.id = id;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getPosition () {
		return position;
	}
	
	public void setPosition (String position) {
		this.position = position;
	}
	
	public double getDaySalary () {
		return daySalary;
	}
	
	public void setDaySalary (double daySalary) {
		this.daySalary = daySalary;
	}
	
	public int getWorkDays () {
		return workDays;
	}
	
	public void setWorkDays (int workDays) {
		this.workDays = workDays;
	}
	
	public double getSalary () {
		return daySalary * workDays;
	}
	
	@Override
	public String toString () {
		return (
			id + "/" + name + "/" + position + "/" + workDays
		);
	}
	
	public void display () {
		DecimalFormat df = new DecimalFormat("#.##");
		String daySalary = df.format(this.daySalary);
		String salary = df.format(getSalary());
		System.out.printf(
			"| %10s | %-25s | %-15s | %10s | %10s | %10s |\n",
			id, name, position, daySalary, workDays, salary
		);
	}
}