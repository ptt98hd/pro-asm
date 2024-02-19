package ticket;

public class StudentTicket extends Ticket {
	public StudentTicket (
		String id, int route, boolean roundTrip, double price
	) {
		super(id, route, "Student Ticket", roundTrip, price * 0.7);
	}
}
