package assignment;

import employee.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public final class Employees extends ArrayList<Employee> implements IFunctions {

	private final ArrayList<Employee> employees;
	private final double baseSalary;
	private final Scanner scanner;

	public Employees() {
		employees = new ArrayList<>();
		baseSalary = 8;
		scanner = new Scanner(System.in);
		load();
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	/**
	 *
	 */
	@Override
	public void add() {
		System.out.println("\n[ ADD AN EMPLOYEE ]");
		String id = Utils.getString("Enter ID: ");
		while (findById(id) != null) {
			System.out.println("ID already exists!");
			id = Utils.getString("Enter ID: ");
		}
		String name = Utils.getString("Enter name: ");
		int position = Utils.getKey("Enter Position: ", Employee.POSITIONS);
		int workDays = Utils.getInt("Enter worked days: ");

		switch (position) {
			case 1:
				employees.add(new NormalEmployee(id, name, baseSalary, workDays));
				break;
			case 2:
				employees.add(new FareController(id, name, baseSalary, workDays));
				break;
			case 3:
				employees.add(new Driver(id, name, baseSalary, workDays));
				break;
			case 4:
				employees.add(new RouteManager(id, name, baseSalary, workDays));
				break;
			case 5:
				employees.add(new Director(id, name, baseSalary, workDays));
				break;
			default:
				break;
		}
		save();
	}

	/**
	 *
	 */
	@Override
	public void remove() {
		System.out.println("\n[ REMOVE AN EMPLOYEE ]");
		String id = Utils.getString("Enter ID: ");
		while (findById(id) == null) {
			System.out.println("Invalid ID!");
			id = Utils.getString("Enter ID: ");
		}
		employees.remove(findById(id));
		save();
	}

	/**
	 *
	 */
	@Override
	public void update() {
		System.out.println("\n[ UPDATE AN EMPLOYEE ]");
		String id = Utils.getString("Enter ID: ");
		while (findById(id) == null) {
			System.out.println("Invalid ID!");
			id = Utils.getString("Enter ID: ");
		}
		String name = Utils.getString("Enter name: ");
		int position = Utils.getKey("Enter Position: ", Employee.POSITIONS);
		int workDays = Utils.getPositiveInt("Enter Worked Days: ");

		Employee employee = findById(id);
		switch (position) {
			case 1:
				employees.add(new NormalEmployee(id, name, baseSalary, workDays));
				break;
			case 2:
				employees.add(new FareController(id, name, baseSalary, workDays));
				break;
			case 3:
				employees.add(new Driver(id, name, baseSalary, workDays));
				break;
			case 4:
				employees.add(new RouteManager(id, name, baseSalary, workDays));
				break;
			case 5:
				employees.add(new Director(id, name, baseSalary, workDays));
				break;
			default:
				break;
		}
		employees.remove(employee);
		save();
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	/**
	 *
	 */
	@Override
	public void listAll() {
		System.out.println("\n[ LIST ALL EMPLOYEES ]");
		Employee.displayHeader();
		employees.forEach(Employee::display);
		Employee.displaySeparator();
	}

	public void listNormalEmployee() {
		System.out.println("\n[ LIST NORMAL EMPLOYEES ]");
		Employee.displayHeader();
		employees.stream().filter(employee -> employee.getPosition() == 1).forEach(Employee::display);
		Employee.displaySeparator();
	}

	public void listFareController() {
		System.out.println("\n[ LIST FARE CONTROLLER ]");
		Employee.displayHeader();
		employees.stream().filter(employee -> employee.getPosition() == 2).forEach(Employee::display);
		Employee.displaySeparator();
	}

	public void listDriver() {
		System.out.println("\n[ LIST DRIVER ]");
		Employee.displayHeader();
		employees.stream().filter(employee -> employee.getPosition() == 3).forEach(Employee::display);
		Employee.displaySeparator();
	}

	public void listRouteManager() {
		System.out.println("\n[ LIST ROUTE MANAGER ]");
		Employee.displayHeader();
		employees.stream().filter(employee -> employee.getPosition() == 4).forEach(Employee::display);
		Employee.displaySeparator();
	}

	public void listDirector() {
		System.out.println("\n[ LIST DIRECTOR ]");
		Employee.displayHeader();
		employees.stream().filter(employee -> employee.getPosition() == 5).forEach(Employee::display);
		Employee.displaySeparator();
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void searchById() {
		System.out.println("\n[ SEARCH EMPLOYEE BY ID ]");
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();
		Employee.displayHeader();
		employees.stream().filter(employee -> employee.getId().equals(id)).forEach(Employee::display);
		Employee.displaySeparator();
	}

	public void searchByName() {
		System.out.println("\n[ SEARCH EMPLOYEE BY NAME ]");
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		Employee.displayHeader();
		employees.stream().filter(employee -> employee.getName().contains(name)).forEach(Employee::display);
		Employee.displaySeparator();
	}

	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public void top5Salary() {
		System.out.println("\n[ TOP 5 HIGHEST SALARY ]");
		employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
		try (
			FileWriter fw = new FileWriter("data/topSalary.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
			int count = 5;
			Employee.displayHeader();
			for (Employee employee : employees) {
				employee.display();
				bw.write(employee.toString());
				bw.newLine();
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
	@Override
	public Employee findById(String id) {
		for (Employee employee : employees) {
			if (employee.getId().equals(id)) {
				return employee;
			}
		}
		return null;
	}

	public boolean account(String id, String password) {
		return findById(id).getPassword().equals(password);
	}

	@Override
	public void load() {
		try (FileReader fr = new FileReader("data/employees.txt"); BufferedReader br = new BufferedReader(fr)) {

			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("/");
				Integer postion = Integer.parseInt(data[2]);
				switch (postion) {
					case 1:
						employees.add(new NormalEmployee(data[0], data[1], baseSalary, Integer.parseInt(data[3]), data[4]));
						break;
					case 2:
						employees.add(new FareController(data[0], data[1], baseSalary, Integer.parseInt(data[3]), data[4]));
						break;
					case 3:
						employees.add(new Driver(data[0], data[1], baseSalary, Integer.parseInt(data[3]), data[4]));
						break;
					case 4:
						employees.add(new RouteManager(data[0], data[1], baseSalary, Integer.parseInt(data[3]), data[4]));
						break;
					case 5:
						employees.add(new Director(data[0], data[1], baseSalary, Integer.parseInt(data[3]), data[4]));
						break;
					default:
						return;
				}
			}
			br.close();
			fr.close();
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error!");
		}
	}

	@Override
	public void save() {
		try (FileWriter fw = new FileWriter("data/employees.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
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
