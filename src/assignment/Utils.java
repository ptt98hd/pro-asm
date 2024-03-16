package assignment;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Utils {

	public static String getString(String prompt) {
		String result = "";
		boolean check = true;
		do {
			System.out.print(prompt);
			Scanner sc = new Scanner(System.in);
			String tmp = sc.nextLine();
			if (!tmp.isEmpty()) {
				result = tmp;
				check = false;
			}
		} while (check);
		return result;
	}

	public static int getInt(String prompt) {
		int number;
		while (true) {
			try {
				System.out.print(prompt);
				Scanner sc = new Scanner(System.in);
				number = Integer.parseInt(sc.nextLine());
				return number;
			} catch (NumberFormatException e) {
				System.out.println("Error, please input number! ");
			}
		}
	}

	public static int getPositiveInt(String prompt) {
		int number = 0;
		do {
			try {
				System.out.print(prompt);
				Scanner sc = new Scanner(System.in);
				number = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, please input number! ");
			}
		} while (number <= 0);
		return number;
	}

	public static double getDouble(String prompt) {
		double number;
		while (true) {
			try {
				System.out.print(prompt);
				Scanner sc = new Scanner(System.in);
				number = Double.parseDouble(sc.nextLine());
				return number;
			} catch (NumberFormatException e) {
				System.out.println("Error, please input number! ");
			}
		}
	}

	public static <V> int getKey(String prompt, Map<Integer, V> options) {
		System.out.print("Available choice: ");
		options.forEach((key, value) -> System.out.printf("[%d] %s; ", key, value));

		Integer choice = null;
		while (choice == null || !options.containsKey(choice)) {
			try {
				System.out.print("\n" + prompt);
				choice = Integer.valueOf(new Scanner(System.in).nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, please input a number!");
				choice = null;
			}
			if (!options.containsKey(choice)) {
				System.out.println("Invalid choice, please try again.");
			}
		}

		return choice;
	}

	public static String getString(String prompt, Map<Integer, String> OPTIONS) {
		System.out.print("Available choice: ");
		for (Map.Entry<Integer, String> entry : OPTIONS.entrySet()) {
			Object key = entry.getKey();
			Object val = entry.getValue();
			System.out.printf(" [%d] %s; ", key, val);
		}
		System.out.println();

		int choice;
		do {
			System.out.print(prompt);
			Scanner sc = new Scanner(System.in);
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (OPTIONS.containsKey(choice)) {
					break;
				} else {
					System.out.println("Invalid choice, please try again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Error, please input a number!");
			}
		} while (true);

		return OPTIONS.get(choice);
	}

	public static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				// Lệnh cho các hệ điều hành khác như Linux hoặc macOS
				Runtime.getRuntime().exec("clear");
			}
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
