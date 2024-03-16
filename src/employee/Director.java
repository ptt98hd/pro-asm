package employee;

public class Director extends Employee {
	public Director (String id, String name, double daySalary, int workDays, String password) {
		super(id, name, 5, daySalary * 4, workDays, password);
	}
	
	public Director (String id, String name, double daySalary, int workDays) {
		super(id, name, 5, daySalary * 4, workDays);
	}
}
