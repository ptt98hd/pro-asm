package employee;

public class Driver extends Employee {
	public Driver (String id, String name, double daySalary, int workDays, String password) {
		super(id, name, 3, daySalary * 1.5, workDays, password);
	}
	
	public Driver (String id, String name, double daySalary, int workDays) {
		super(id, name, 3, daySalary * 1.5, workDays);
	}
}
