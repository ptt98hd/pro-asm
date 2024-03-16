package ticket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Ticket implements Serializable {
	private String id;
	private int route;
	private String type;
	private boolean roundTrip;
	private double price;
	public static final Map<Integer, String> POSITIONS = new HashMap<>();
	
	static {
		POSITIONS.put(1, "Normal Employee");
		POSITIONS.put(2, "Fare Controller");
		POSITIONS.put(3, "Driver");
		POSITIONS.put(4, "Route Manager");
		POSITIONS.put(5, "Director");
	}
	
	public Ticket (
		String id, int route, String type, boolean roundTrip, double price
	) {
		this.id = id;
		this.route = route;
		this.type = type;
		this.roundTrip = roundTrip;
		this.price = roundTrip ? price * 2 : price;
	}
	
	public Ticket () {
	}
	
	public static void displayHeader () {
		displaySeparator();
		System.out.printf(
			"| %-10s | %-10s | %-15s | %-10s | %-10s |\n",
			"ID", "ROUTE", "TYPE", "ROUND TRIP", "PRICE"
		);
		displaySeparator();
	}
	
	public static void displaySeparator () {
		System.out.printf(
			"+-%-10s-+-%-10s-+-%-15s-+-%-10s-+-%-10s-+\n",
			"----------", "----------", "---------------", "----------", "----------"
		);
	}
	
	public String getId () {
		return id;
	}
	
	public void setId (String id) {
		this.id = id;
	}
	
	public int getRoute () {
		return route;
	}
	
	public void setRoute (int route) {
		this.route = route;
	}
	
	public String getType () {
		return type;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	public boolean isRoundTrip () {
		return roundTrip;
	}
	
	public void setRoundTrip (boolean roundTrip) {
		this.roundTrip = roundTrip;
		this.price = roundTrip ? price * 2 : price;
	}
	
	public double getPrice () {
		return price;
	}
	
	public void setPrice (double price) {
		this.price = roundTrip ? price * 2 : price;
	}
	
	@Override
	public String toString () {
		return id + "/" + route + "/" + type + "/" + roundTrip;
	}
	
	public void display () {
		System.out.printf(
			"| %-10s | %-10s | %-15s | %-10s | %-10s |\n",
			id, route, type, roundTrip, price
		);
	}
}
