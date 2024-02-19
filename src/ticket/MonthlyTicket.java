package ticket;

public class MonthlyTicket extends Ticket {
	public MonthlyTicket (
		String id, int route, double price
	) {
		super(id, route, "Monthly Ticket", true, price * 0.5 * 30);
	}
}
