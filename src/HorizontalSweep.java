/*IN this class we implement horizontal sweep strategy. 
 * Here we search for ships in the grid cell by cell moving from 
 * left to right then from bottom to top till we find all the ships 
 * */

public class HorizontalSweep implements SearchShips {
	
	public void findShips(int[][] grid) {
		//Initializing counter,carrier,submarine,noOfSearches variables for operations
		int noOfSearches = 0;
		int counter = 0;
		String carrier ="";
		String submarine= "";
		//Initialization ends
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid.length;j++) {
				if (grid[i][j] != 0) {
	                if (grid[i][j] == 1) {
	                	carrier = carrier + "(" +i +","+ j+")";
	                	counter++;
	                }
	                else if(grid[i][j] == 2 ) {
	                	submarine = submarine + "(" +i +","+ j+")" ;
	                	counter++;
	                		                	
	                }				
				}				
				
				if (counter==8) {
					j=26;
					i=26;
					noOfSearches--;
				}
				noOfSearches++;
			}
		}
		
		// Printing Results for this search 
		System.out.println("Strategy: Horizontal sweep");
		System.out.println("Found Carrier at "+ carrier);
		System.out.println("Found Submarine at "+ submarine);
		System.out.println("Number of cells searched "+ noOfSearches);
			
		
	
		
}
}
