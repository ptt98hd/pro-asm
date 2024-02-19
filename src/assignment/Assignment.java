package assignment;

import employee.Employees;
import ticket.Tickets;

import java.io.IOException;
import java.util.Scanner;

public class Assignment {
	
	public static void main (String[] args) throws IOException {
		Employees employees = new Employees();
		Tickets tickets = new Tickets();
		Scanner scanner = new Scanner(System.in);
		label:
		while (true) {
			switch (choice(scanner)) {
				case 1:
					employees.add();
					enter(scanner);
					break;
				case 2:
					employees.update();
					enter(scanner);
					break;
				case 3:
					employees.remove();
					enter(scanner);
					break;
				case 4:
					employees.listAll();
					enter(scanner);
					break;
				case 5:
					employees.listNormalEmployee();
					enter(scanner);
					break;
				case 6:
					employees.listFareController();
					enter(scanner);
					break;
				case 7:
					employees.listDriver();
					enter(scanner);
					break;
				case 8:
					employees.listRouteManager();
					enter(scanner);
					break;
				case 9:
					employees.listDirector();
					enter(scanner);
					break;
				case 10:
					employees.searchById();
					enter(scanner);
					break;
				case 11:
					employees.searchByName();
					enter(scanner);
					break;
				case 12:
					employees.top5Salary();
					enter(scanner);
					break;
				case 13:
					employees.top1HighestSalary();
					enter(scanner);
					break;
				case 14:
					employees.top2LowestSalary();
					enter(scanner);
					break;
				case 15:
					employees.totalSalary();
					enter(scanner);
					break;
				case 16:
					tickets.add();
					enter(scanner);
					break;
				case 17:
					tickets.update();
					enter(scanner);
					break;
				case 18:
					tickets.remove();
					enter(scanner);
					break;
				case 19:
					tickets.listAll();
					enter(scanner);
					break;
				case 20:
					tickets.listNormalTicket();
					enter(scanner);
					break;
				case 21:
					tickets.listStudentTicket();
					enter(scanner);
					break;
				case 22:
					tickets.listSeniorTicket();
					enter(scanner);
					break;
				case 23:
					tickets.listDailyTicket();
					enter(scanner);
					break;
				case 24:
					tickets.listMonthlyTicket();
					enter(scanner);
					break;
				case 25:
					tickets.sortByPriceAcd();
					enter(scanner);
					break;
				case 26:
					tickets.sortByPriceDcd();
					enter(scanner);
					break;
				case 27:
					tickets.top5LowestPrice();
					enter(scanner);
					break;
				case 28:
					tickets.totalSold();
					enter(scanner);
					break;
				default:
					break label;
			}
		}
	}
	
	public static int choice (Scanner scanner) {
		System.out.println("\n[ MENU ]");
		separator();
		System.out.printf(
			"| %-30s | %-30s |%n", "           EMPLOYEE", "            TICKET"
		);
		separator();
		System.out.printf(
			"| %-30s | %-30s |%n", "[01] Add an Employee", "[16] Add a Ticket"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[02] Update an Employee", "[17] Update a Ticket"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[03] Remove an Employees", "[18] Remove a Ticket"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[04] List All Employee", "[19] List all Tickets"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[05] List Normal Employee", "[20] List Normal Tickets"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[06] List Fare Controller", "[21] List Student Tickets"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[07] List Driver", "[22] List Senior Tickets"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[08] List Route Manager", "[23] List Daily Ticket"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[09] List Director", "[24] List Monthly Ticket"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[10] Search by ID", "[25] Sort by Price Ascending"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[11] Search by Name", "[26] Sort by Price Descending"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[12] Top 5 Salary", "[27] Top 5 Lowest Price"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[13] Top 1 Highest Salary", "[28] Total Tickets Revenues"
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[14] Top 2 Lowest Salary", ""
		);
		System.out.printf(
			"| %-30s | %-30s |%n", "[15] Total Salary", ""
		);
		separator();
		int choice = -1;
		while (choice < 0 || choice > 28) {
			try {
				System.out.print("Your Choice: ");
				choice = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid Choice!");
			}
		}
		return choice;
	}
	
	public static void enter (Scanner scanner) {
		System.out.print("Press [Enter] to continute...");
		try {
			scanner.nextLine();
		} catch (Exception e) {
		}
	}
	
	public static void separator () {
		System.out.printf(
			"+-%-30s-+-%-30s-+%n",
			"------------------------------", "------------------------------"
		);
	}
}
