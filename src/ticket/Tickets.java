package ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tickets {
	
	private ArrayList<Ticket> tickets;
	private double basePrice;
	
	private Scanner scanner;
	
	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public Tickets () {
		tickets = new ArrayList<>();
		basePrice = 1;
		scanner = new Scanner(System.in);
		loadTickets();
	}
	
	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void add () {
		System.out.println("\n[ ADD A TICKET ]");
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();
		while (findById(id) != null) {
			System.out.println("ID already exists!");
			System.out.print("Enter ID: ");
			id = scanner.nextLine();
		}
		
		int route = 0;
		while (route < 1) {
			try {
				System.out.print("Enter route: ");
				route = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invaled route!");
			}
		}
		
		switch (types()) {
			case "Normal Ticket":
				tickets.add(new NormalTicket(id, route, roundTrip(), basePrice));
				break;
			case "Student Ticket":
				tickets.add(new StudentTicket(id, route, roundTrip(), basePrice));
				break;
			case "Senior Ticket":
				tickets.add(new SeniorTicket(id, route, roundTrip(), basePrice));
				break;
			case "Daily Ticket":
				tickets.add(new DailyTicket(id, route, basePrice));
				break;
			case "Monthly Ticket":
				tickets.add(new MonthlyTicket(id, route, basePrice));
				break;
			default:
				break;
		}
		saveTickets();
	}
	
	public void remove () {
		System.out.println("\n[ REMOVE A TICKET ]");
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();
		while (findById(id) == null) {
			System.out.println("Invalid ID!");
			System.out.print("Enter ID: ");
			id = scanner.nextLine();
		}
		tickets.remove(findById(id));
		saveTickets();
	}
	
	public void update () {
		System.out.println("\n[ UPDATE A TICKET ]");
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();
		while (findById(id) == null) {
			System.out.println("Invalid ID!");
			System.out.print("Enter ID: ");
			id = scanner.nextLine();
		}
		
		int route = 0;
		while (route < 1) {
			try {
				System.out.print("Enter route: ");
				route = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invaled route!");
			}
		}
		
		switch (types()) {
			case "Normal Ticket":
				tickets.add(new NormalTicket(id, route, roundTrip(), basePrice));
				break;
			case "Student Ticket":
				tickets.add(new StudentTicket(id, route, roundTrip(), basePrice));
				break;
			case "Senior Ticket":
				tickets.add(new SeniorTicket(id, route, roundTrip(), basePrice));
				break;
			case "Daily Ticket":
				tickets.add(new DailyTicket(id, route, basePrice));
				break;
			case "Monthly Ticket":
				tickets.add(new MonthlyTicket(id, route, basePrice));
				break;
			default:
				break;
		}
		tickets.remove(findById(id));
		saveTickets();
	}
	
	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void listAll () {
		System.out.println("\n[ LIST ALL TICKETS ]");
		Ticket.displayHeader();
		for (Ticket ticket : tickets) {
			ticket.display();
		}
		Ticket.displaySeparator();
	}
	
	public void listNormalTicket () {
		System.out.println("\n[ LIST NORMAL TICKETS ]");
		Ticket.displayHeader();
		for (Ticket ticket : tickets) {
			if (ticket.getType().equals("Normal Ticket")) {
				ticket.display();
			}
		}
		Ticket.displaySeparator();
	}
	
	public void listStudentTicket () {
		System.out.println("\n[ LIST STUDENT TICKETS ]");
		Ticket.displayHeader();
		for (Ticket ticket : tickets) {
			if (ticket.getType().equals("Student Ticket")) {
				ticket.display();
			}
		}
		Ticket.displaySeparator();
	}
	
	public void listSeniorTicket () {
		System.out.println("\n[ LIST SENIOR TICKETS ]");
		Ticket.displayHeader();
		for (Ticket ticket : tickets) {
			if (ticket.getType().equals("Senior Ticket")) {
				ticket.display();
			}
		}
		Ticket.displaySeparator();
	}
	
	public void listDailyTicket () {
		System.out.println("\n[ LIST DAILY TICKETS ]");
		Ticket.displayHeader();
		for (Ticket ticket : tickets) {
			if (ticket.getType().equals("Daily Ticket")) {
				ticket.display();
			}
		}
		Ticket.displaySeparator();
	}
	
	public void listMonthlyTicket () {
		System.out.println("\n[ LIST ALL TICKETS ]");
		Ticket.displayHeader();
		for (Ticket ticket : tickets) {
			if (ticket.getType().equals("Monthly Ticket")) {
				ticket.display();
			}
		}
		Ticket.displaySeparator();
	}
	
	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void sortByPriceAcd () {
		System.out.println("\n[ SORT BY PRICE ASCENDING ]");
		tickets.sort((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()));
		Ticket.displayHeader();
		for (Ticket ticket : tickets) {
			ticket.display();
		}
		Ticket.displaySeparator();
	}
	
	public void sortByPriceDcd () {
		System.out.println("\n[ SORT BY PRICE DESCENDING ]");
		tickets.sort((t1, t2) -> Double.compare(t2.getPrice(), t1.getPrice()));
		Ticket.displayHeader();
		for (Ticket ticket : tickets) {
			ticket.display();
		}
		Ticket.displaySeparator();
	}
	
	public void top5LowestPrice () {
		System.out.println("\n[ TOP 5 LOWEST PRICE TICKETS ]");
		tickets.sort((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()));
		Ticket.displayHeader();
		
		try (
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/topPrice.dat"))
		) {
			for (int i = 0; i < 5; i++) {
				tickets.get(i).display();
				oos.writeObject(tickets.get(i));
			}
		} catch (Exception e) {
		}
		Ticket.displaySeparator();
	}
	
	public void totalSold () {
		System.out.println("\n[ TOTAL SOLD TICKET ]");
		double total = 0;
		for (Ticket ticket : tickets) {
			total += ticket.getPrice();
		}
		System.out.println(total);
	}
	
	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public Ticket findById (String id) {
		for (Ticket ticket : tickets) {
			if (ticket.getId().equals(id)) {
				return ticket;
			}
		}
		return null;
	}
	
	public String types () {
		System.out.println("Available types: ");
		System.out.println("   [01] Normal Ticket");
		System.out.println("   [02] Student Ticket");
		System.out.println("   [03] Senior Ticket");
		System.out.println("   [04] Daily Ticket");
		System.out.println("   [05] Monthly Ticket");
		int choice = -1;
		while (choice < 0 || choice > 1) {
			try {
				System.out.print("Enter type: ");
				choice = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid choice!");
			}
		}
		switch (choice) {
			case 1:
				return "Normal Ticket";
			case 2:
				return "Student Ticket";
			case 3:
				return "Senior Ticket";
			case 4:
				return "Daily Ticket";
			case 5:
				return "Monthly Ticket";
			default:
				return null;
		}
	}
	
	public boolean roundTrip () {
		System.out.println("Round Trip?");
		System.out.printf("%-10s %-10s\n", "[0] No", "[1] Yes");
		int choice = -1;
		while (choice < 0 || choice > 1) {
			try {
				System.out.print("Your choice: ");
				choice = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid choice!");
			}
		}
		return choice == 1;
	}
	
	public void loadTickets () {
		try {
			FileReader fr = new FileReader("data/tickets.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("/");
				switch (data[2]) {
					case "Normal Ticket":
						tickets.add(new NormalTicket(
							data[0],
							Integer.parseInt(data[1]),
							data[3].equals("true") ? true : false,
							basePrice
						));
						break;
					case "Student Ticket":
						tickets.add(new StudentTicket(
							data[0],
							Integer.parseInt(data[1]),
							data[3].equals("true") ? true : false,
							basePrice
						));
						break;
					case "Senior Ticket":
						tickets.add(new SeniorTicket(
							data[0],
							Integer.parseInt(data[1]),
							data[3].equals("true") ? true : false,
							basePrice
						));
						break;
					case "Daily Ticket":
						tickets.add(new DailyTicket(
							data[0],
							Integer.parseInt(data[1]),
							basePrice
						));
						break;
					case "Monthly Ticket":
						tickets.add(new MonthlyTicket(
							data[0],
							Integer.parseInt(data[1]),
							basePrice
						));
						break;
					default:
						break;
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}
	
	public void saveTickets () {
		try {
			FileWriter fw = new FileWriter("data/tickets.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Ticket ticket : tickets) {
				bw.write(ticket.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}
}
