package atm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class atmRunner {
		private static String name = "";
		private static int pin = 0;
		static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path fileToRead = Paths.get("./resources/data.txt");
		List<String> list = Files.readAllLines(fileToRead);
		BankAccount account = new BankAccount(list.get(0).toString(), Integer.parseInt(list.get(1)), Double.parseDouble(list.get(2)));
		retrieveCredentials();
		if(login(account)) {
			System.out.print("Choose option, W for withdaw or D for deposit: ");
			String option = scan.next();
			System.out.print("Enter Amount: ");
			double amount = scan.nextDouble();
			switch (option) {
			case "W": 
					account.withdraw(amount);
					break;
			case "D":
					account.depoist(amount);
					break;
			default:
					System.out.println("Invalid options selected");
					
			}
			System.out.println(account);
			
		}
		scan.close();
	}
	
	private static boolean login(BankAccount account) {
		if(name.equalsIgnoreCase(account.getName())&& pin == account.getPin()){
			System.out.println(account);
			return true;
		}else {
			System.out.println("Unable to login. Try again later");
			return false;
		}
	}
	
	private static void retrieveCredentials() {
		System.out.print("Enter name: ");
		name = scan.next();
		System.out.print("Enter pin: ");
		pin = scan.nextInt();
	}

}
