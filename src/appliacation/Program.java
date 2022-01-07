package appliacation;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double deposit = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, withdrawLimit);
		acc.deposit(deposit);

		System.out.println("Create Account: " + acc);

		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double withdraw = sc.nextDouble();

		try {
			acc.withdraw(withdraw);

		} catch (BusinessException e) {

			System.out.println(e.getMessage());

		} catch (RuntimeException e) {

			System.out.println("Unexpected error");
		}

		sc.close();

	}

}
