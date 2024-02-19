package employee;

public class FareController extends Employee {
	public FareController (String id, String name, double daySalary, int workDays) {
		super(id, name, "Fare Controller", daySalary * 1.1, workDays);
	}
}
