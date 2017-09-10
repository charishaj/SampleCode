/*
 * Class to validate user inputs
 */
public class InputValidator {
	
	
	public InputValidator() {
		
	}
	
	public boolean validateInput(String input1, String input2, String input3) {
		
		boolean inputValid = true;
		
		
		//check user inputs are not empty
		if(input1.equals("") || input2.equals("") || input3.equals("")) {
			inputValid = false;
			return inputValid;
			
		}
	
		//check x and y inputs are numeric and are positive numbers 
	   if(!isPositiveNumber(input1) || !isPositiveNumber(input2)) {
		   inputValid = false;
		   return inputValid;
	   }
	   
	   //check input3 is either north, south, east or west
	   
	   if(!input3.toUpperCase().equals("NORTH") && !input3.toUpperCase().equals("SOUTH") && !input3.toUpperCase().equals("EAST") && !input3.toUpperCase().equals("WEST")){
		   
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
