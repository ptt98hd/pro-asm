package ticket;

public class SeniorTicket extends Ticket {
	public SeniorTicket (
		String id, int route, boolean roundTrip, double price
	) {
		super(id, route, "Senior Ticket", roundTrip, price * 0.5);
	}
}
