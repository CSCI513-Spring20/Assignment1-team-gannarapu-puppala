/* 
 *                                      Assignment 1
 * 																		Name = Rakshith, Venkat Aravind
 * 																		CSCI 513
 * 
 */


//Importing Required Packages
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/*Class for doing all the operations including 
 * 1. Reading from text file
 * 2. Mapping Ships location on Multi-dimensional matrix for each game
 * 3. Creating Instances for classes
 * 4. Using Search Strategies
 */

public class BattleShip {
	// Initializing grid1,grid2,grid3,carrier and submarine variables for using in operations
	String token1,token2,token3;
	static int k = 1;
	int carrier =  1; // Carrier
	int subMarine = 2; // Submarine
	int[][] grid = new int[25][25];
	static int[][] grid2 = new int[25][25]; //Game 1
	static int[][] grid3 = new int[25][25]; //Game 2
	static int[][] grid1 = new int[25][25]; // Game 3
	
	// Creating Instances for each class
	HorizontalSweep horizonatlSweep = new HorizontalSweep();
	RandomSearchStrategy randomSearch = new RandomSearchStrategy();
	StrategicSearch strategicSearch = new StrategicSearch(); 
	
	//This method is used to copy ships locations to grids for each different game
	public void copyArray(int[][] initialGrid, int[][] finalGrid) {
		
	    for (int i = 0; i < initialGrid.length; ++i) {
	         System.arraycopy(initialGrid[i], 0, finalGrid[i], 0, finalGrid[i].length);
	      }
	     	
	}
	 // This method is used to call different strategies for each game
	public void playGame(int[][] game) {
		System.out.println();
		horizonatlSweep.findShips(game); // Calling finships method in Horizontal Sweep class
		System.out.println("\n");
		randomSearch.findShips(game); // Calling finships method in Random search strategy class
		System.out.println("\n");
		strategicSearch.findShips(game); // Calling finships method in Strategic search class
	}

	/* In this method, We read the input file and split each line such that ships 
	 * coordinates are placed on respective grids or games. We use copy method to copy into respective grids */
	public void placingShips() {
		String path = "src/input.txt";
		try {
			FileReader inputFile = new FileReader(path);
			BufferedReader reader = new BufferedReader(inputFile);
			String line;

			while((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, "()") ;
				for(int i =0;i<8;i++) {
					token1 = tokenizer.nextToken();
					StringTokenizer tokenizer1 = new StringTokenizer(token1, ",") ;
					token2 = tokenizer1.nextToken();
					token3 = tokenizer1.nextToken();
					if(i<5) {
						grid[Integer.parseInt(token2)][Integer.parseInt(token3)] = carrier;						
					}
					else {
						grid[Integer.parseInt(token2)][Integer.parseInt(token3)] = subMarine;
						
					}
					
					}
				if (k == 1) {
					copyArray(grid,grid1); // Calling copyArray Method for loading game1 grid
				}
				else if(k == 2) {
					copyArray(grid,grid2); // Calling copyArray Method for loading game2 grid
				}
				else {
					copyArray(grid,grid3); // Calling copyArray Method for loading game3 grid
				} 
				for (int row = 0; row < grid.length; row++) {
					   for (int col = 0; col < grid.length; col++) {
					      grid[row][col] = 0;
					   }
					}
				k++;				
					
			 }
			reader.close();
			} // Exceptional handling 
			catch (Exception e) {
			e.printStackTrace();
			
			}
		
	}

	// This is the main method where all the operations occurs
	public static void main(String[] args) {
		BattleShip battleShip = new BattleShip();
		battleShip.placingShips();	
		 
		// Game 1
		System.out.println("Playing Game1");
		// Results for Game 1
		battleShip.playGame(grid1);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		
		//Game 2
		System.out.println("Playing Game2");
		// Results for Game 2
		battleShip.playGame(grid2);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		
		//Game3
		// Results for Game 3
		System.out.println("Playing Game3");
		battleShip.playGame(grid3);
			
	}

}
