/*
 * Class to validate user inputs
 */
public class InputValidator {
	
	
	public InputValidator() {
		
	}
	
	public boolean validatePlaceInputs(String input1, String input2, String input3, String commandInput) {
		
		boolean inputValid = true;
		
		//check if the input is a Place input
		if(!commandInput.equals("PLACE")) {
			inputValid = false;
			return inputValid;
		}
		
		
		//check user inputs are not empty
		if(input1.equals("") || input2.equals("") || input3.equals("")) {
			inputValid = false;
			System.out.println("place variables are empty");
			return inputValid;
			
		}
	
		//check x and y inputs are numeric and are positive numbers 
	   if(!isPositiveNumber(input1) || !isPositiveNumber(input2)) {
		   System.out.println("x and y positions must be a positive number");
		   inputValid = false;
		   return inputValid;
	   }
	   else {
		   
		   //check x and y are less than 4
		   if(Integer.parseInt(input1) > 4 || Integer.parseInt(input2)>4) {
			   System.out.println("x and y positions must be between 0 and 4");
			   inputValid = false;
			   return inputValid;
		   }
		   
	   }
	   

	   
	   //check input3 is either north, south, east or west
	   
	   if(!input3.toUpperCase().equals("NORTH") && !input3.toUpperCase().equals("SOUTH") && !input3.toUpperCase().equals("EAST") && !input3.toUpperCase().equals("WEST")){
		   System.out.println("Direction facing must be NORTH, SOUTH, EAST or WEST");
		   inputValid = false;
	   }
	   
		
		return inputValid;
	}
	
	//check the string is a positive number
	public boolean isPositiveNumber(String str)  
	{  
		boolean isPositiveNumber = false;
		
		//check if string is numeric
	  try  
	  {  
	    double d = Double.parseDouble(str); 
	    //check string is positive
	    if(d > 0) {
	    	 isPositiveNumber = true;
	    }
	  }  
	  catch(NumberFormatException nfe)  
	  {   
		  isPositiveNumber = false;  
	  }  
	  return isPositiveNumber;  
	}

}
