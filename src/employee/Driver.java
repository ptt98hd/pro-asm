package employee;

public class Driver extends Employee {
	public Driver (String id, String name, double daySalary, int workDays) {
		super(id, name, "Driver", daySalary * 1.5, workDays);
	}
}
