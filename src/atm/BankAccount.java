package atm;

public class BankAccount {
	private String name;
	private int pin;
	private double balance;
	public BankAccount(String name, int pin, double balance) {
		super();
		this.name = name;
		this.pin = pin;
		this.balance = balance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Name: " + name + "\nBalance: " +balance;
	}
}
