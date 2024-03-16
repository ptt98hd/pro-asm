package employee;

public class FareController extends Employee {
	public FareController (String id, String name, double daySalary, int workDays, String password) {
		super(id, name, 2, daySalary * 1.1, workDays, password);
	}
	
	public FareController (String id, String name, double daySalary, int workDays) {
		super(id, name, 2, daySalary * 1.1, workDays);
	}
}
