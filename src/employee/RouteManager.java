package employee;

public class RouteManager extends Employee {
	public RouteManager (String id, String name, double daySalary, int workDays, String password) {
		super(id, name, 4, daySalary * 2, workDays, password);
	}
	
	public RouteManager (String id, String name, double daySalary, int workDays) {
		super(id, name, 4, daySalary * 2, workDays);
	}
}
