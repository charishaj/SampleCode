	/*
	 * Represent a robot object
	 */

public class Robot {
	
	private int xPosition;
	private int yPosition;
	private String directionFacing;
	

	
	public Robot() {
		
	}
	
	public Robot(int xPosition, int yPosition, String directionFacing) {
		
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.directionFacing = directionFacing;
		
	}
	
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public String getDirectionFacing() {
		return directionFacing;
	}
	public void setDirectionFacing(String directionFacing) {
		this.directionFacing = directionFacing;
	}
	
	

}
