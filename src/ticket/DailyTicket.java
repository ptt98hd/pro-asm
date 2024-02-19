package ticket;

public class DailyTicket extends Ticket {
	public DailyTicket (
		String id, int route, double price
	) {
		super(id, route, "Daily Ticket", true, price);
	}
}
