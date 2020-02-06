/*This class is used to implement Random strategy
 * Here we select non repeated randomly cells and if the selected cell has coordinates of ship, we will note.
 * We will repeat the above step till we find all the coordinates of ships
 * We will interpret the noted coordinates into understandable way 
 * */

import java.util.Arrays;
import java.util.Random;

public class RandomSearchStrategy implements SearchShips {
	
		
		public void findShips(int[][] grid) {	
			//Initializing temp,i,j,counter,count,carrier1,carrier2,rand,submarine1,submarine2 variables for operations
			int[][] temp = new int[25][25];
			int i =0;
			int j =0;
			int counter = 0;
			int count =0;
			int[] carrier1 = new int[5];
			int[] carrier2 = new int[5];
			
			int[] submarine1 = new int[3];
			int[] submarine2 = new int[3];
			
			Random rand =  new Random();
			//Initialization ends
			
			// Loop for looking carrier and submarine coordinates
			while(count!=2) {
			int a = rand.nextInt(25);
			int b = rand.nextInt(25);
			if(temp[a][b]!=1) {
				if(grid[a][b]==1) {
					carrier1[i] = a;
					carrier2[i]= b;
					i++;
					if (i==5) {count++;}
					
				}
				else if(grid[a][b]==2) {
					submarine1[j] = a;
					submarine2[j] = b;
					j++;
					if (j==3) {count++;}
					
				}
				temp[a][b] =1;
				counter++;
				
			}
			
			}
			
			// Sorting arrays 
			Arrays.sort(carrier1);
			Arrays.sort(carrier2);
			Arrays.sort(submarine1);
			Arrays.sort(submarine2);
			
			// Printing Results for this search 
			System.out.println("Strategy: Random Search strategy");
			System.out.println("Found Carrier from ("+carrier1[0]+","+carrier2[0]+") to ("+carrier1[4]+","+carrier2[4]+")");
			System.out.println("Found SubMarine from ("+submarine1[0]+","+submarine2[0]+") to ("+submarine1[2]+","+submarine2[2]+")");
			System.out.println("No of Searches = "+counter);
			
			
		}

}
