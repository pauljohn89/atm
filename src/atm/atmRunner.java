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
		private static double amount = 0.0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path fileToRead = Paths.get("./resources/data.txt");
		List<String> list = Files.readAllLines(fileToRead);
		BankAccount account = new BankAccount(list.get(0).toString(), Integer.parseInt(list.get(1)), Double.parseDouble(list.get(2)));
		retrieveCredentials();
		int i = 0;
		if(login(account)) {
			do {
				System.out.print("Choose option, W for withdaw or D for deposit or E to exit: ");
				String option = scan.next();
				switch (option.toUpperCase()) {
				case "W": 
						System.out.print("Enter Amount: ");
						amount = scan.nextDouble();
						account.withdraw(amount);
						break;
				case "D":
						System.out.print("Enter Amount: ");
						amount = scan.nextDouble();
						account.depoist(amount);
						break;
				case "E":
						i++;
					    break;
				default:
						System.out.println("Invalid options selected");
						break;
						
				}
				System.out.println(account);
			}while(i<1);
		}
		scan.close();
		logout(fileToRead, account);
			
	}

	private static void logout(Path fileToRead, BankAccount account) throws IOException {
		if(Files.deleteIfExists(fileToRead)) {
			List<String> newlist = List.of(account.getName(),Integer.toString(account.getPin()),Double.toString(account.getBalance()));
			Files.write(fileToRead, newlist);
			System.out.println("Changes Saved!");
		}else {
			System.out.println("Unable to save changes!");
		}
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
