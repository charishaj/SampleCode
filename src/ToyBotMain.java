import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Main method of the ToyRobit Game
 */

public class ToyBotMain {
	
	
	public static void main(String[] args) throws IOException {
		
		
		//UI object
		UserInterface userInterface = new UserInterface();
		
		//the robot
		Robot robot = new Robot();
		
		
		//start game
		userInterface.startGame(robot);
		
		
	
	}

}
