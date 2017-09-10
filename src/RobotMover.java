import java.util.Scanner;

/*
	 * Moves the robot object
	 */

public class RobotMover {
	

	
	public RobotMover() {
		
	}
	
	public Robot moveForward(Robot robot, String command) {
		
		
		
		return robot;
		
	}
	
	public Robot rotateLeft(Robot robot, String command) {
		
		
		return robot;
	}
	
	public Robot rotateRight(Robot robot, String command) {
		
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
