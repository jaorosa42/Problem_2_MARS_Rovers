package marsrovers;

import java.util.List;

public class Rover {
	private int posX;
	private int posY;
	private char orientation;
	private String moving; 
	
	public Rover(int posX, int posY, char orientation, String moving) {
		this.posX = posX;
		this.posY = posY;
		this.orientation = orientation;
		this.moving = moving;
	}		
		
	public void setPosX(int position) {
		this.posX = position;
	}
		
	public void setPosY(int position) {
		this.posY = position;
	}
		
	public void setOrientation(char ori) {
		this.orientation = ori;
	}
		
	public int getPosX() {
		return this.posX;
	}
		
	public int getPosY() {
		return this.posY;
	}
		
	public char getOrientation() {
		return this.orientation;
	}
	
	public String getMoving() {
		return this.moving;
	}
	
	//applying rover movement
	public static void toMove(List<Rover> rovers, int maxX, int maxY) {		
		for(int i=0;i<rovers.size();i++) {			
			for(int j=0; j<rovers.get(i).getMoving().length();j++) {				
				if(rovers.get(i).getMoving().charAt(j) == 'L'){		        		
	        		if(rovers.get(i).getOrientation() == 'N') rovers.get(i).setOrientation('W');
	        		else if(rovers.get(i).getOrientation() == 'S') rovers.get(i).setOrientation('E');
	        		else if(rovers.get(i).getOrientation() == 'E') rovers.get(i).setOrientation('N');
	        		else if(rovers.get(i).getOrientation() == 'W') rovers.get(i).setOrientation('S');
	        		else {
	        			System.out.println("Orientation NOT Selected!");
	        		}
	        	}
	        	else if(rovers.get(i).getMoving().charAt(j) == 'R'){		        		
	        		if(rovers.get(i).getOrientation() == 'N') rovers.get(i).setOrientation('E');
	        		else if(rovers.get(i).getOrientation() == 'S') rovers.get(i).setOrientation('W');
	        		else if(rovers.get(i).getOrientation() == 'E') rovers.get(i).setOrientation('S');
	        		else if(rovers.get(i).getOrientation() == 'W') rovers.get(i).setOrientation('N');
	        		else {
	        			System.out.println("Orientation NOT Selected!");
	        		}
	        	}
	        	else if(rovers.get(i).getMoving().charAt(j) == 'M') {		        		
	        		if(rovers.get(i).getOrientation() == 'N') {
	        			rovers.get(i).setPosY(rovers.get(i).getPosY()+1);
	        			if(rovers.get(i).getPosY() > maxY || rovers.get(i).getPosY() < 0) System.out.println("\nCAUTION!\nRover #"+(i+1)+"is out of plateau!"); 
	        		}	        			
	        		else if(rovers.get(i).getOrientation() == 'S') {
	        			rovers.get(i).setPosY(rovers.get(i).getPosY()-1);
	        			if(rovers.get(i).getPosY() > maxY || rovers.get(i).getPosY() < 0) System.out.println("\nCAUTION!\nRover #"+(i+1)+"is out of plateau!");
	        		}	        			
	        		else if(rovers.get(i).getOrientation() == 'E') {
	        			rovers.get(i).setPosX(rovers.get(i).getPosX()+1);
	        			if(rovers.get(i).getPosX() > maxX || rovers.get(i).getPosX() < 0) System.out.println("\nCAUTION!\nRover #"+(i+1)+"is out of plateau!");
	        		}        			
	        		else if(rovers.get(i).getOrientation() == 'W') {
	        			rovers.get(i).setPosX(rovers.get(i).getPosX()-1);
	        			if(rovers.get(i).getPosX() > maxX || rovers.get(i).getPosX() < 0) System.out.println("\nCAUTION!\nRover #"+(i+1)+"is out of plateau!");
	        		}	        			
	        		else {
	        			System.out.println("Orientation NOT Selected!");
	        		}
	        	}
	        	else {
	        		System.out.println("Direction NOT Selected!");
	        	}				
			}			
		}		
	}
	
	//to print rovers last position
	public static void toPrint(List<Rover> rovers, int maxX, int maxY) {
		for(int i=0;i<rovers.size();i++) {
			System.out.println("Final Position Rover #"+(i+1)+": "+" "+rovers.get(i).getPosX()+" "+rovers.get(i).getPosY()+" "+rovers.get(i).getOrientation());
			if(rovers.get(i).getPosX() > maxX || rovers.get(i).getPosX() < 0) System.out.println("\nCAUTION!\nRover #"+(i+1)+"is out of plateau!");
			if(rovers.get(i).getPosY() > maxY || rovers.get(i).getPosY() < 0) System.out.println("\nCAUTION!\nRover #"+(i+1)+"is out of plateau!");
		}		
	}
}
