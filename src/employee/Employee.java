package employee;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee {

	public static final Map<Integer, String> POSITIONS = new HashMap<>();

	static {
		POSITIONS.put(1, "Normal Employee");
		POSITIONS.put(2, "Fare Controller");
		POSITIONS.put(3, "Driver");
		POSITIONS.put(4, "Route Manager");
		POSITIONS.put(5, "Director");
	}

	private String id;
	private String name;
	private int position;
	private double daySalary;
	private int workDays;

	private String password;

	public Employee(String id, String name, int position, double daySalary, int workDays, String password) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.daySalary = daySalary;
		this.workDays = workDays;
		this.password = password;
	}

	public Employee(String id, String name, int position, double daySalary, int workDays) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.daySalary = daySalary;
		this.workDays = workDays;
	}

	public Employee() {
	}

	public static void displayHeader() {
		displaySeparator();
		System.out.printf(
			"| %10s | %-25s | %-15s | %10s | %10s | %10s |\n",
			"ID", "NAME", "POSITION", "DAY SALARY", "WORK DAYS", "SALARY"
		);
		displaySeparator();
	}

	public static void displaySeparator() {
		System.out.printf(
			"+-%-10s-+-%-25s-+-%-15s-+-%-10s-+-%-10s-+-%-10s-+ %n",
			"----------", "-------------------------", "---------------", "----------", "----------", "----------"
		);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getDaySalary() {
		return daySalary;
	}

	public void setDaySalary(double daySalary) {
		this.daySalary = daySalary;
	}

	public int getWorkDays() {
		return workDays;
	}

	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}

	public double getSalary() {
		return daySalary * workDays;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return (id + "/" + name + "/" + position + "/" + workDays + "/" + password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Employee employee = (Employee) obj;
		return Objects.equals(id, employee.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void display() {
		DecimalFormat df = new DecimalFormat("#.##");
		String daySalary = df.format(this.daySalary);
		String salary = df.format(getSalary());
		System.out.printf(
			"| %10s | %-25s | %-15s | %10s | %10s | %10s |\n",
			id, name, POSITIONS.get(position), daySalary, workDays, salary
		);
	}
}
