import java.io.Console;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
/*
 * Class to handle user inputs
 */
public class UserInterface {
	
	private Console console;
	
	public UserInterface() {
		
		
	}
	
	//method called at the start of the gme
	public Robot startGame(Robot robot) {
		
		boolean validCommand =false;
		Scanner sc = new Scanner(System.in);
		String xString = "";
		String yString = "";
		String directionString = "";
		
		
		do {
			//show user the instructions
		
			System.out.println("Instructions: Type PLACE and enter the X,Y position of the Robot along with the direction (NORTH, SOUTH, EAST, WEST) it is facing");
			System.out.println("e.g 3,2,NORTH");
			System.out.println("");
			
			System.out.println("Enter command: ");
			Scanner scanner = new Scanner(System.in);
			String command = scanner.nextLine().trim();
			
			//split the command into its various parts
			String[] commandParts = command.split(",");
			xString = commandParts[0];
			yString = commandParts[1];
			directionString = commandParts[2];
			
			InputValidator inputValidator = new InputValidator();
			
			//validation to check user input has the right number of parts
			if(!(commandParts.length == 3)) {
				validCommand = false;
				System.out.println("Invalid command. Try again. ERRROR 1");
				System.out.println("");
				
			}
			
			else {
					//validation to check each user input part is acceptable 
					if(!inputValidator.validateInput(xString, yString, directionString)) {
						validCommand = false;
						System.out.println("Invalid command. Try again. ERROR 2");
						System.out.println("");
					}
					else {
						validCommand = true;
					}
	
			}
		    
		} while (validCommand == false);
		
		//set the start co-ordinates and direction facing of the robot

		robot.setxPosition(Integer.parseInt(xString));
		robot.setyPosition(Integer.parseInt(yString));
		robot.setDirectionFacing(directionString.toUpperCase());
		
		return robot;
	}

}
