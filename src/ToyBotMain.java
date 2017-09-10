import java.io.IOException;
import java.util.Scanner;

public class ToyBotMain {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Your username is " + username);
	
	}

}
