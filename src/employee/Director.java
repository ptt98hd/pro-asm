package employee;

public class Director extends Employee {
	public Director (String id, String name, double daySalary, int workDays) {
		super(id, name, "Director", daySalary * 4, workDays);
	}
}
