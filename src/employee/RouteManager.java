package employee;

public class RouteManager extends Employee {
	public RouteManager (String id, String name, double daySalary, int workDays) {
		super(id, name, "Route Manager", daySalary * 2, workDays);
	}
}
