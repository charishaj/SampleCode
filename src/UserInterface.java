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
	
	
	
	public void report(Robot robot) {
		
		System.out.println(robot.getxPosition() + "," + robot.getyPosition() + "," + robot.getDirectionFacing());
	}
	

	
}
