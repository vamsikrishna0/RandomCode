import java.util.*;

public class Solution {

	static int[][] timerOnSlot;
	static int r, c, n;

	static char[][] grid;
	static final char OFF = '.';
	static final char ON = 'O';
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		n = sc.nextInt();
		grid = new char[r][c];
		timerOnSlot = new int[r][c];
		
		
		for(int i = 0 ;i < r;i++){
			grid[i] = sc.nextLine().toCharArray();
			
		}
		initializeTimers();
		updateTimers();
		
		while(n != 0){
			updateTimers();
			updateBombs();
		}
		
		for(int k=0 ;k<c; k++){
			for(int j=0 ; j<r ; j++){
				System.out.print(grid[j][k]);
				
			}
			System.out.println();
		}
		sc.close();
	}
	public static void updateTimers(){
		for(int k=0 ;k<c; k++){
			for(int j=0 ; j<r ; j++){
				n--;
				if(grid[j][k]== ON){
					timerOnSlot[j][k]--;
					if(timerOnSlot[j][k] == 0){
						grid[j][k] = OFF;
						updateSurrounding(j, k);
					}
						
				}
				
			}
		}
	}

	public static void updateBombs(){
		for(int k=0 ;k<c; k++){
			for(int j=0 ; j<r ; j++){
				n--;
				if(grid[j][k]== OFF){
					grid[j][k] = ON;
					timerOnSlot[j][k] = 3;
				}
			}
		}
	}
	
	public static void updateSurrounding(int j, int k){
		grid[j-1][k]= OFF;
		timerOnSlot[j-1][k]=0;
		timerOnSlot[j+1][k] = 0;
		timerOnSlot[j][k-1]=0;
	    timerOnSlot[j][k+1] = 0;
		grid[j+1][k]= OFF;
		grid[j][k-1]= OFF;
		grid[j][k+1]= OFF;
		
	}
	public static void initializeTimers(){
		for(int k=0 ; k<c ; k++){
			for(int j=0 ; j<r ; j++){
				if(grid[j][k]== ON){
					timerOnSlot[j][k] = 3;
				}else
					timerOnSlot[j][k] = 0;
				
			}
		}
	}
}