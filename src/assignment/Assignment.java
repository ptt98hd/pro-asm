package assignment;

import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {

		loop:
		while (true) {
			switch (login()) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					menu();
					enter();
					break;
				case 0:
					changePassword();
					enter();
					break;
				default:
					break loop;
			}
		}
	}

	public static int login() {
		System.out.println("\n[ LOGIN ]");
		Employees employees = new Employees();
		String id, password;
		do {
			id = Utils.getString("Enter ID: ");
			if (id.equals("0")) {
				return 0;
			}
			if (employees.findById(id) == null) {
				System.out.println("Invalid ID, Try again!");
			}
		} while (employees.findById(id) == null);
		do {
			password = Utils.getString("Enter password: ");
			if (password.equals("0")) {
				return 0;
			}
			if (!employees.account(id, password)) {
				System.out.println("Wrong password, Try again!");
			}
		} while (!employees.account(id, password));
		return employees.findById(id).getPosition();
	}

	public static void changePassword() {
		System.out.println("\n[ CHANGE PASSWORD ]");
		Employees employees = new Employees();
		String id, password;
		do {
			id = Utils.getString("Enter ID: ");
			if (employees.findById(id) == null) {
				System.out.println("Invalid ID, Try again!");
			}
		} while (employees.findById(id) == null);
		do {
			password = Utils.getString("Enter Old password: ");
			if (!employees.account(id, password)) {
				System.out.println("Wrong password, Try again!");
			}
		} while (!employees.account(id, password));
		employees.findById(id).setPassword(Utils.getString("Enter new password: "));
		employees.save();
	}

	public static void menu() {
		Employees employees = new Employees();
		Tickets tickets = new Tickets();
		while (true) {
			switch (choice()) {
				case 1:
					employees.add();
					enter();
					break;
				case 2:
					employees.update();
					enter();
					break;
				case 3:
					employees.remove();
					enter();
					break;
				case 4:
					employees.listAll();
					enter();
					break;
				case 5:
					employees.listNormalEmployee();
					enter();
					break;
				case 6:
					employees.listFareController();
					enter();
					break;
				case 7:
					employees.listDriver();
					enter();
					break;
				case 8:
					employees.listRouteManager();
					enter();
					break;
				case 9:
					employees.listDirector();
					enter();
					break;
				case 10:
					employees.searchById();
					enter();
					break;
				case 11:
					employees.searchByName();
					enter();
					break;
				case 12:
					employees.top5Salary();
					enter();
					break;
				case 13:
					employees.top1HighestSalary();
					enter();
					break;
				case 14:
					employees.top2LowestSalary();
					enter();
					break;
				case 15:
					employees.totalSalary();
					enter();
					break;
				case 16:
					tickets.add();
					enter();
					break;
				case 17:
					tickets.update();
					enter();
					break;
				case 18:
					tickets.remove();
					enter();
					break;
				case 19:
					tickets.listAll();
					enter();
					break;
				case 20:
					tickets.listNormalTicket();
					enter();
					break;
				case 21:
					tickets.listStudentTicket();
					enter();
					break;
				case 22:
					tickets.listSeniorTicket();
					enter();
					break;
				case 23:
					tickets.listDailyTicket();
					enter();
					break;
				case 24:
					tickets.listMonthlyTicket();
					enter();
					break;
				case 25:
					tickets.sortByPriceAcd();
					enter();
					break;
				case 26:
					tickets.sortByPriceDcd();
					enter();
					break;
				case 27:
					tickets.top5LowestPrice();
					enter();
					break;
				case 28:
					tickets.totalSold();
					enter();
					break;
				default:
//					Utils.clearConsole();
					return;
			}
		}
	}

	public static int choice() {
		Scanner scanner = new Scanner(System.in);
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
			"| %-30s | %-30s |%n", "[15] Total Salary", "[00] LOGOUT"
		);
		separator();
		int choice = -1;
		while (choice < 0 || choice > 28) {
			try {
				System.out.print("Your Choice: ");
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Choice!");
			}
		}
		return choice;
	}

	public static void separator() {
		System.out.printf(
			"+-%-30s-+-%-30s-+%n",
			"------------------------------", "------------------------------"
		);
	}

	public static void enter() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Press [Enter] to continute...");
		scanner.nextLine();
	}
}
