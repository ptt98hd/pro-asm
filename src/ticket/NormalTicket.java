package ticket;

public class NormalTicket extends Ticket {
	public NormalTicket (
		String id, int route, boolean roundTrip, double price
	) {
		super(id, route, "Normal Ticket", roundTrip, price);
	}
}
