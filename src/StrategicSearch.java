/*This class is used to implement Strategic Search
 * Here we select non repeated randomly cells and if the selected cell has coordinates of ship
 * we will note that coordinates
 * We will search for the ship moving along horizontally or vertically by making noted coordinates as origin
 * */

import java.util.Random;

public class StrategicSearch implements SearchShips {
	
public void findShips(int[][] grid) {
	
	// Initializing temp, carrier, submarine,a,b,rand, carr, sub, noOfSearches variables for operations
	int[][] temp = new int[25][25];
	int carrier = 0;
	int submarine =0;
	int a,b;
	Random rand =  new Random();
	int count =0;
	int[] carr = new int[2];
	int[] sub = new int[2];
	int noOfSearches = 0;
	int k =0;
	// Initialization ends
	
	// Loop for finding at least one coordinates of carrier and submarine 
	while(count!=2) {
		
		a = rand.nextInt(25);
		b = rand.nextInt(25);
		if(temp[a][b]!=1) {
		if(grid[a][b] == 1 & carrier == 0) {
			carrier = 1;
			count++;
			carr[0] =a;
			carr[1] =b;
			
		}
		else if(grid[a][b] == 2 & submarine == 0) {
			submarine = 1;
			count++;
			sub[0] =a;
			sub[1] =b;
			
		}
		
		temp[a][b] =1;
		noOfSearches++;
		}
	

	

	}
	
	System.out.println("Strategy: Strategic Search");
	
	//Printing Results
	int[] data  = findLocation(grid,carr,1,4);
	noOfSearches = noOfSearches + data[0];
	
	if(data[1]!=1) {
		 k =carr[1]+4;
		System.out.println("Found Carrier from ("+carr[0]+","+carr[1]+") to ("+carr[0]+","+k+")");
	}
	else {
		k =carr[0]+4;
		
	System.out.println("Found Carrier from ("+carr[0]+","+carr[1]+") to ("+k+","+carr[1]+")");
	}

	data  = findLocation(grid,sub,2,2);
	noOfSearches = noOfSearches + data[0];
	
	if(data[1]!=1) {
		 k =sub[1]+2;
		System.out.println("Found Submarine from ("+sub[0]+","+sub[1]+") to ("+sub[0]+","+k+")");
	}
	else {
		k =sub[0]+2;
		
	System.out.println("Found Submarine from ("+sub[0]+","+sub[1]+") to ("+k+","+sub[1]+")");
	}
	
	
	System.out.println("No of Searches "+noOfSearches);
	
}
	

/*This method is used to find the coordinates of ships by searching around one coordinates
 * */	

private int[] findLocation(int[][] grid,int[] ship,int st,int m) {
	int[] result = new int[2];
	int vert = 1 ;
	int count =0;
		for(int i=0;i< grid.length-m;i++) {
			if(grid[ship[0]][i]==st & grid[ship[0]][i+m]==st) {
				ship[1] =i;
				count++;
				i=26;
				vert=0;
				
			}		
			
		}
		
		if(vert==1) {
			for(int j=0;j< grid.length-m;j++) {
				if(grid[j][ship[1]]==st & grid[j+m][ship[1]]==st) {
					ship[0] =j;
					count++;
					j=26;					
				}
								
			}
	}
	result[0] = count;
	result[1] = vert;
	return result; // Returning count and and ship alignment
}

}

