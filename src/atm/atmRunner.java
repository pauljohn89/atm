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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path fileToRead = Paths.get("./resources/data.txt");
		List<String> list = Files.readAllLines(fileToRead);
		BankAccount account = new BankAccount(list.get(0).toString(), Integer.parseInt(list.get(1)), Double.parseDouble(list.get(2)));
		retrieveCredentials();
		login(account);
	}
	private static void login(BankAccount account) {
		if(name.equalsIgnoreCase(account.getName())&& pin == account.getPin()){
			System.out.println(account);
		}else {
			System.out.println("Unable to login. Try again later");
		}
	}
	private static void retrieveCredentials() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter name: ");
		name = scan.next();
		System.out.print("Enter pin: ");
		pin = scan.nextInt();
		scan.close();
	}

}
