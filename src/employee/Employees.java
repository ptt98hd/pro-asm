package employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class Employees {

	private final ArrayList<Employee> employees;
	private final double baseSalary;
	private final Scanner scanner;

	public Employees() {
		employees = new ArrayList<>();
		baseSalary = 8;
		scanner = new Scanner(System.in);
		loadEmployees();
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void add() {
		System.out.println("\n[ ADD AN EMPLOYEE ]");
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();
		while (findById(id) != null) {
			System.out.println("ID already exists!");
			System.out.print("Enter ID: ");
			id = scanner.nextLine();
		}
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		String position = positions();
		int workDays = -1;
		while (workDays < 0) {
			try {
				System.out.print("Enter work days: ");
				workDays = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Work Days!");
				workDays = -1;
			}
		}

		switch (position) {
			case "Normal Employee":
				employees.add(new NormalEmployee(id, name, baseSalary, workDays));
				break;
			case "Fare Control":
				employees.add(new FareController(id, name, baseSalary, workDays));
				break;
			case "Driver":
				employees.add(new Driver(id, name, baseSalary, workDays));
				break;
			case "Route Manager":
				employees.add(new RouteManager(id, name, baseSalary, workDays));
				break;
			case "Director":
				employees.add(new Director(id, name, baseSalary, workDays));
				break;
			default:
				break;
		}
		saveEmployees();
	}

	public void remove() {
		System.out.println("\n[ REMOVE AN EMPLOYEE ]");
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();
		while (findById(id) == null) {
			System.out.println("Invalid ID!");
			System.out.print("Enter ID: ");
			id = scanner.nextLine();
		}
		employees.remove(findById(id));
		saveEmployees();
	}

	public void update() {
		System.out.println("\n[ UPDATE AN EMPLOYEE ]");
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();
		while (findById(id) == null) {
			System.out.println("Invalid ID!");
			System.out.print("Enter ID: ");
			id = scanner.nextLine();
		}
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		String position = positions();
		int workDays = -1;
		while (workDays < 0) {
			try {
				System.out.print("Enter work days: ");
				workDays = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid work days!");
				workDays = -1;
			}
		}

		Employee employee = findById(id);
		switch (position) {
			case "Normal Employee":
				employees.add(new NormalEmployee(id, name, baseSalary, workDays));
				break;
			case "Fare Controller":
				employees.add(new FareController(id, name, baseSalary, workDays));
				break;
			case "Driver":
				employees.add(new Driver(id, name, baseSalary, workDays));
				break;
			case "Route Manager":
				employees.add(new RouteManager(id, name, baseSalary, workDays));
				break;
			case "Director":
				employees.add(new Director(id, name, baseSalary, workDays));
				break;
			default:
				break;
		}
		employees.remove(employee);
		saveEmployees();
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void listAll() {
		System.out.println("\n[ LIST ALL EMPLOYEES ]");
		Employee.displayHeader();
		for (Employee employee : employees) {
			employee.display();
		}
		Employee.displaySeparator();
	}

	public void listNormalEmployee() {
		System.out.println("\n[ LIST NORMAL EMPLOYEES ]");
		Employee.displayHeader();
		for (Employee employee : employees) {
			if (employee.getPosition().equals("Normal Employee")) {
				employee.display();
			}
		}
		Employee.displaySeparator();
	}

	public void listFareController() {
		System.out.println("\n[ LIST FARE CONTROLLER ]");
		Employee.displayHeader();
		for (Employee employee : employees) {
			if (employee.getPosition().equals("Fare Controller")) {
				employee.display();
			}
		}
		Employee.displaySeparator();
	}

	public void listDriver() {
		System.out.println("\n[ LIST DRIVER ]");
		Employee.displayHeader();
		for (Employee employee : employees) {
			if (employee.getPosition().equals("Driver")) {
				employee.display();
			}
		}
		Employee.displaySeparator();
	}

	public void listRouteManager() {
		System.out.println("\n[ LIST ROUTE MANAGER ]");
		Employee.displayHeader();
		for (Employee employee : employees) {
			if (employee.getPosition().equals("Route Manager")) {
				employee.display();
			}
		}
		Employee.displaySeparator();
	}

	public void listDirector() {
		System.out.println("\n[ LIST DIRECTOR ]");
		Employee.displayHeader();
		for (Employee employee : employees) {
			if (employee.getPosition().equals("Director")) {
				employee.display();
			}
		}
		Employee.displaySeparator();
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void searchById() {
		System.out.println("\n[ SEARCH EMPLOYEE BY ID ]");
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();

		Employee.displayHeader();
		for (Employee employee : employees) {
			if (employee.getId().equals(id)) {
				employee.display();
			}
		}
		Employee.displaySeparator();
	}

	public void searchByName() {
		System.out.println("\n[ SEARCH EMPLOYEE BY NAME ]");
		System.out.print("Enter name: ");
		String name = scanner.nextLine();

		Employee.displayHeader();
		for (Employee employee : employees) {
			if (employee.getName().contains(name)) {
				employee.display();
			}
		}
		Employee.displaySeparator();
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void top5Salary() {
		System.out.println("\n[ TOP 5 HIGHEST SALARY ]");
		employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
		try {
			FileWriter fw = new FileWriter("data/topSalary.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			int count = 5;
			Employee.displayHeader();
			for (Employee employee : employees) {
				bw.write(employee.toString());
				bw.newLine();
				employee.display();
				count--;
				if (count == 0) {
					break;
				}
			}
			Employee.displaySeparator();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}

	public void top1HighestSalary() {
		System.out.println("\n[ TOP 1 HIGHEST SALARY ]");
		employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
		Employee.displayHeader();
		employees.get(0).display();
		Employee.displaySeparator();
	}

	public void top2LowestSalary() {
		System.out.println("\n[ TOP 2 LOWEST SALARY ]");
		employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
		Employee.displayHeader();
		employees.get(employees.size() - 2).display();
		Employee.displaySeparator();
	}

	public void totalSalary() {
		System.out.println("\n[ TOTAL SALARY ]");
		double salary = 0;
		for (Employee employee : employees) {
			salary += employee.getSalary();
		}
		System.out.println(salary);
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public Employee findById(String id) {
		for (Employee employee : employees) {
			if (employee.getId().equals(id)) {
				return employee;
			}
		}
		return null;
	}

	public String positions() {
		System.out.println("Available position: ");
		System.out.println("   [01] Normal Employee");
		System.out.println("   [02] Fare Controller");
		System.out.println("   [03] Driver");
		System.out.println("   [04] Route Manager");
		System.out.println("   [05] Director");
		int choice = 0;
		while (choice < 1 || choice > 5) {
			try {
				System.out.print("Enter position: ");
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid choice!");
			}
		}
		switch (choice) {
			case 1:
				return "Normal Employee";
			case 2:
				return "Fare Controller";
			case 3:
				return "Driver";
			case 4:
				return "Route Manager";
			case 5:
				return "Director";
			default:
				return null;
		}
	}

	public void loadEmployees() {
		try {
			FileReader fr = new FileReader("data/employees.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("/");
				switch (data[2]) {
					case "Normal Employee":
						employees.add(new NormalEmployee(data[0], data[1], baseSalary, Integer.parseInt(data[3])));
						break;
					case "Fare Controller":
						employees.add(new FareController(data[0], data[1], baseSalary, Integer.parseInt(data[3])));
						break;
					case "Driver":
						employees.add(new Driver(data[0], data[1], baseSalary, Integer.parseInt(data[3])));
						break;
					case "Route Manager":
						employees.add(new RouteManager(data[0], data[1], baseSalary, Integer.parseInt(data[3])));
						break;
					case "Director":
						employees.add(new Director(data[0], data[1], baseSalary, Integer.parseInt(data[3])));
						break;
					default:
						break;
				}
			}
			br.close();
			fr.close();
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error!");
		}
	}

	public void saveEmployees() {
		try {
			FileWriter fw = new FileWriter("data/employees.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Employee employee : employees) {
				bw.write(employee.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}
}
