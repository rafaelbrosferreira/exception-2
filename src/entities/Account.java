package entities;

import exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = 0.0;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}

	public void deposit(double deposit) {

		String d = String.valueOf(deposit);

		if (d.contains("^[a-Z]")) {

			throw new BusinessException("Invalid");

		} else {
			
			Double e = Double.parseDouble(d);

			this.balance += e;
		}

	}

	public void withdraw(double amount) {

		if (amount > getWithDrawLimit()) {

			throw new BusinessException("Withdraw error: The amount exceeds withdraw limit.");

		} else if (amount > getBalance()) {

			throw new BusinessException("Erro Withdraw: Not enough balance.");

		} else {

			this.balance -= amount;
			System.out.println("New balance: " + getBalance());

		}

	}

	public String toString() {
		return "Number: " + getNumber() + " Holder: " + getHolder() + " Balance: " + getBalance() + " Withdraw limit: "
				+ getWithDrawLimit();

	}

}
