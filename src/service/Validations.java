package service;

import java.util.Scanner;

public class Validations {
	static Scanner sc;
	static boolean run;
	public String mobileValidation() {
		String inputMobile = null;
		run = true;
		while (run == true) {
			sc = new Scanner(System.in);
			inputMobile = sc.nextLine();
			if (checkMobile(inputMobile) == true) {
				run = false;
			} else {
				System.out.println("Invalid Date no enter again");

			}

		}
		return inputMobile;

	}

	public static boolean checkMobile(String inputMobile) {
		// TODO Auto-generated method stub
		if (inputMobile.length() == 10) {
			for (int i = 0; i < inputMobile.length(); i++) {
				if (!(inputMobile.charAt(i) >= '0' && inputMobile.charAt(i) <= '9')) {
					return false;
				}
			}
		} else
			return false;

		return true;

	}

	public String validinput() {
		sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

	public int integerValidation() {
		// TODO Auto-generated method stub
		run = true;
		int inputInteger = 0;
		while (run == true) {
			sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				inputInteger = sc.nextInt();
				if (inputInteger < 0) {
					System.out.println("Can't be negative");
					continue;
				}
				run = false;
			} else {
				System.out.println("Invalid input");
			}
		}

		return inputInteger;
	}

	

}
