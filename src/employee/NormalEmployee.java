package employee;

public class NormalEmployee extends Employee {
	public NormalEmployee (String id, String name, double daySalary, int workDays, String password) {
		super(id, name, 1, daySalary, workDays, password);
	}
	
	public NormalEmployee (String id, String name, double daySalary, int workDays) {
		super(id, name, 1, daySalary, workDays);
	}
}
