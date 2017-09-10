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
	
	
	
	public String start() {
		
		System.out.println("Instructions: Type PLACE and enter the X,Y position of the Robot along with the direction (NORTH, SOUTH, EAST, WEST) it is facing");
		System.out.println("e.g 3,2,NORTH");
		System.out.println("");
		
		System.out.println("Enter command: ");
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine().trim();
		
		return command; 
		
	}
	
	public void report(Robot robot) {
		
		System.out.println(robot.getyPosition() + "," + robot.getxPosition() + "," + robot.getDirectionFacing());
	}
	
	public String receiveUserCommand() {
		
		System.out.println("");
		System.out.println( "Type any of the following commands to continue game:");
		System.out.println("");
		System.out.println("PLACE X position,Y position, Direction Facing \n" + 
				"MOVE\n" + 
				"LEFT\n" + 
				"RIGHT\n" + 
				"REPORT");
		
		//ask user for command
		System.out.println("");
		System.out.println("Enter command: ");
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine().trim().toUpperCase();
		
		return command;

  }
	
}
