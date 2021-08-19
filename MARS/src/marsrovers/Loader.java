package marsrovers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class to use file methods
public class Loader {
	
	// method to fill Rovers Array List
	public static List<Rover> populateSquad(String name) { 		
		try {
			File myObj = new File(name);
			Scanner myReader = new Scanner(myObj);
			int lines = NumberOfRovers(name);
		
			List<Rover> squad = new ArrayList<Rover>();
			
			myReader.nextLine();
			
			//generate requested number of rovers
			for(int i=0;i<lines;i++) {
				String rover = myReader.nextLine();
				String moving = myReader.nextLine();
				
				//casting String to Integer 
				int x = Character.getNumericValue(rover.charAt(0));	
				int y = Character.getNumericValue(rover.charAt(2));	
				char orientation = rover.charAt(4);
				
				squad.add(new Rover(x,y,orientation,moving));				
			}			
			myReader.close();
			return squad;
				
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return null;
		}
	}
	
	//get number of rovers inside squad using file lines
	public static int NumberOfRovers(String name) {
		
		try{
			File myObj = new File(name);
		    Scanner myReader = new Scanner(myObj);
		    int lines=0;
		    while (myReader.hasNextLine()) {
		    	myReader.nextLine();
		        lines++;
		    }
		    lines--;
		    myReader.close();
		    
		    return lines/2;
		} 
		catch(FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return 0;
		}
	}
	
	//method used to take the limits of plateau
	public static String getPlateau(String name) { 
		try{
			File myObj = new File(name);
		    Scanner myReader = new Scanner(myObj);
		    String plateau = myReader.nextLine();
		    myReader.close();
		    return plateau;
		} 
		catch(FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return null;
		}		
	}	
}
