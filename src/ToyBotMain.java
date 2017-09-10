import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Main method of the ToyRobit Game
 */

public class ToyBotMain {
	
	
	public static void main(String[] args) throws IOException {
		
		boolean gameStarted = true;
		
		//UI object
		UserInterface userInterface = new UserInterface();
		
		//the robot
		Robot robot = new Robot();

		//user command
	
		String command = "";
		
		
		//robotMover
		RobotMover robotMover = new RobotMover();
		
		//String inputFileName = args[0];
		//String inputFileName = "input/input7.txt";
		System.out.println("Input text files are located in the input folder");
		System.out.println("Enter file name with .txt extension");
		System.out.println(" e.g input7.txt");
		Scanner sc = new Scanner(System.in);
		String inputFileName = sc.nextLine();
		
		ArrayList<String> inputArray = new ArrayList<String>();
		FileInputStream fstream;
		try {
			
		    fstream = new FileInputStream("input/"+inputFileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			
			String strLine;

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
			  inputArray.add(strLine.trim().toUpperCase());
			}
			
			//Close the input stream
			br.close();
						
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Input file not found");
			//e.printStackTrace();
		}
		
		

			//start game
			// userInterface.start()
			 command = inputArray.get(0);
			
			 //look for place command
			if(command.contains("PLACE")) {
				
				robot = robotMover.placeRobot(robot, command);
				gameStarted = true;
				
				//check if robot has been initiated
				if ((robot.getDirectionFacing() == null)) {
					gameStarted = false;
				}
			}
			else {
				System.out.println("Invalid Start Command.");
				gameStarted = false;
			}
			
		
		
		//continue game
		if(gameStarted) {
			for(int i = 1; i < inputArray.size(); i++) {
			
				command = inputArray.get(i);
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
		            default: System.out.println(command + " is an invalid command. Try again.");
							 System.out.println("");
		                     break;
	
			
		        }
		    }
		
		}

	
	}

}
