import java.util.Scanner;

/*
	 * Moves the robot object
	 */

public class RobotMover {
	

	
	public RobotMover() {
		
	}
	
	//Move robot a step forward
	public Robot moveForward(Robot robot, String command) {
		
		//check direction the robot is facing
		
		String directionFacing = robot.getDirectionFacing();
		int newXPosition = robot.getxPosition();
		int newYPosition = robot.getyPosition(); 
		
		switch (directionFacing) {
        case "NORTH": 
        				newYPosition = robot.getyPosition() + 1;
                 	break;
        case "SOUTH":
        				newYPosition = robot.getyPosition() - 1;
        				break;
        case "EAST": 
        				newXPosition = robot.getxPosition() + 1;
        				break;
        case "WEST":
        				newXPosition = robot.getxPosition() - 1;
        			    break;
        default: System.out.println("Error. Direction robot is facing is invalid");
        			 System.out.println("");
        break;
		}
		
		//check if new x and y positions are valid
		InputValidator inputValidator = new InputValidator();
		
		if(inputValidator.validateXYPositions(newXPosition, newYPosition)) {
			robot.setxPosition(newXPosition);
			robot.setyPosition(newYPosition);
		}
		
		
		return robot;
		
	}
	
	//rotate robot left
	public Robot rotateLeft(Robot robot) {
		
		String directionFacing = robot.getDirectionFacing();
		
		switch (directionFacing) {
        case "NORTH": 
        				robot.setDirectionFacing("WEST");
                 	break;
        case "SOUTH":
        				robot.setDirectionFacing("EAST");
        				break;
        case "EAST": 
        				robot.setDirectionFacing("NORTH");
        				break;
        case "WEST":
        				robot.setDirectionFacing("SOUTH");
        			    break;
        default: System.out.println("Error. Direction robot is facing is invalid");
        			 System.out.println("");
        break;
		}
		
		
		return robot;
	}
	
	//rotate robot right
	public Robot rotateRight(Robot robot) {
		
String directionFacing = robot.getDirectionFacing();
		
		switch (directionFacing) {
        case "NORTH": 
        				robot.setDirectionFacing("EAST");
                 	break;
        case "SOUTH":
        				robot.setDirectionFacing("WEST");
        				break;
        case "EAST": 
        				robot.setDirectionFacing("SOUTH");
        				break;
        case "WEST":
        				robot.setDirectionFacing("NORTH");
        			    break;
        default: System.out.println("Error. Direction robot is facing is invalid");
        			 System.out.println("");
        break;
		}
		
		return robot;
	}
	
	//place robot at a position
		public Robot placeRobot(Robot robot, String command) {
			
			boolean validCommand =false;
			Scanner sc = new Scanner(System.in);
			String xString = "";
			String yString = "";
			String directionString = "";
			String commandString = "";

				
				//split the command into its various parts
				String[] commandParts = command.split(",");
				
				
				InputValidator inputValidator = new InputValidator();
				
				//validation to check user input has the right number of parts
				if(!(commandParts.length == 3)) {
					validCommand = false;
					System.out.println("Invalid command. Try again.");
					System.out.println("");
					return robot;
					
				}
				

						//get the parts of the input
						
					    //check the first part of command contains a space
						if(!commandParts[0].contains(" ")){
							validCommand = false;
							System.out.println("Invalid command. Try again.");
							System.out.println("");
							return robot;
							
						}
					
						else {
							//get the place command
							String [] placeCommandArray = commandParts[0].split(" ");
							commandString = placeCommandArray[0].trim().toUpperCase();
							xString = placeCommandArray[1].trim();
							yString = commandParts[1].trim();
							directionString = commandParts[2].trim().toUpperCase();
						
							//validation to check each user input part is acceptable 
							if(!inputValidator.validatePlaceInputs(xString, yString, directionString, commandString)) {
								validCommand = false;
								System.out.println("Invalid command. Try again.");
								System.out.println("");
								return robot;
							}
						}
		

			    
			
			//set the start co-ordinates and direction facing of the robot

			robot.setxPosition(Integer.parseInt(xString));
			robot.setyPosition(Integer.parseInt(yString));
			robot.setDirectionFacing(directionString);
			
			return robot;
		}

}
