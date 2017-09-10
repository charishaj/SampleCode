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
		
		boolean gameStarted = true;
		boolean gameOver = false;
		
		//UI object
		UserInterface userInterface = new UserInterface();
		
		//the robot
		Robot robot = new Robot();

		//user command
	
		String command = "";
		
		
		//robotMover
		RobotMover robotMover = new RobotMover();
		
		//start game
		do {
			//start game
			command = userInterface.start().toUpperCase();
			
			if(command.contains("PLACE")) {
				
				robot = robotMover.placeRobot(robot, command);
				gameStarted = true; 
			}
			else {
				System.out.println("Invalid Command.");
				gameStarted = false;
			}
			
		}while(!gameStarted);
		
		
		//continue game
		do {
			
			command = userInterface.receiveUserCommand();
			String commandType = "";
		
			if(command.contains("PLACE")) {
				commandType = "PLACE";
			}
			if(command.equals("MOVE")) {
				commandType = "MOVE";
			}
			if(command.equals("LEFT")){
				commandType = "LEFT";
			}
			if(command.equals("RIGHT")) {
				commandType = "RIGHT";
			}
			if(command.equals("REPORT")) {
				commandType = "REPORT";
			}
			
	
	        switch (commandType) {
	            case "PLACE":  robot = robotMover.placeRobot(robot, command);
	                     break;
	            case "MOVE": robot = robotMover.moveForward(robot, command);
	                     break;
	            case "LEFT":  robot = robotMover.rotateLeft(robot);
	                     break;
	            case "RIGHT": robot = robotMover.rotateRight(robot);
	                     break;
	            case "REPORT": userInterface.report(robot);
	            			 break;
	            default: System.out.println("Invalid command. Try again.");
						 System.out.println("");
	                     break;

		
	}
		}
		while(!gameOver);
		
		
		
		
	
	}

}
