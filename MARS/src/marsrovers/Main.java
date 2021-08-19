package marsrovers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int opc;		
			
		System.out.println("\nMARS Rovers\nWhich way do you want to insert rovers positions and movements?\n1.File\n2.Console");		
		opc = in.nextInt();
		
		//selecting insertion mode
		switch(opc) {		
			case 1:
				System.out.println("\nWhere is the data text file?");
				String name = in.next();
				
				List<Rover> squad = Loader.populateSquad(name);						
				
				String p = Loader.getPlateau(name);
				
				int maxX = p.charAt(0);
				int maxY = p.charAt(2);
								
				Rover.toMove(squad,maxX,maxY);				
				Rover.toPrint(squad,maxX,maxY);
				
				break;
				
			case 2:
				/*java Scanner has some insertion problems for different variables types
				so I had to create more variables to threat this problem*/
				Scanner e = new Scanner(System.in);				
				Scanner n = new Scanner(System.in);				
				Scanner pla = new Scanner(System.in);				
				
				List<Rover> rovers = new ArrayList<>();
				
				System.out.println("\nPlateau Coordinates: ");
				String plateau = pla.nextLine();
				
				System.out.println("\nHow many rovers do you want to?");
				int numberOfRovers = e.nextInt();
				
				//instantiating rovers Array List
				for(int i=0;i<numberOfRovers;i++){
					
					System.out.println("\nRover #"+(i+1)+" Position: ");
					String position = n.nextLine();
					
					System.out.println("\nRover #"+(i+1)+" Movement: ");
					String movement = n.nextLine();					
						
					int x = Character.getNumericValue(position.charAt(0));
					int y = Character.getNumericValue(position.charAt(2));
					char o = position.charAt(4);
						
					rovers.add(new Rover(x,y,o,movement));											
				}
				
				//casting plateau upper-coordinates to Integer to match constructors parameters
				int maxxX = Character.getNumericValue(plateau.charAt(0));
				int maxxY = Character.getNumericValue(plateau.charAt(0));				
				
				Rover.toMove(rovers,maxxX,maxxY);				
				Rover.toPrint(rovers,maxxX,maxxY);	
				
				break;
		}				
	}
}

