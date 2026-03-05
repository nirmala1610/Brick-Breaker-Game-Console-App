package com.kce.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BrickBreakerService {

	private String[][] grid = new String[7][7];
	private int ballRow = 6;
	private int ballCol = 3;
	private int lives = 5;
	
	private Map<String,Integer> bricks = new HashMap<>();
	
	public void initilizeBoard() {
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				
				if(i==0 || i==6 || j==0 || j==6)
					 grid[i][j] = "W";
				else
					grid[i][j]=" ";
			}
		}
		
		    grid[6][1]="g";
	        grid[6][2]="g";
	        grid[6][3]="o";
	        grid[6][4]="g";
	        grid[6][5]="g";

	        addBrick(2,2,1);
	        addBrick(2,3,1);
	        addBrick(2,4,1);
	        addBrick(3,2,1);
	        addBrick(3,3,1);
	        addBrick(3,4,1);
		
	}
	
	private void addBrick(int r,int c,int strength) {
		grid[r][c] = String.valueOf(strength);
		bricks.put(r + ","+c, strength);
	}
	
	public void printGrid() {
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void moveBall(String command) {

	    int dRow = -1;
	    int dCol = 0;

	    if(command.equalsIgnoreCase("Lt"))
	        dCol = -1;
	    else if(command.equalsIgnoreCase("Rt"))
	        dCol = 1;

	    int row = ballRow;
	    int col = ballCol;

	    while(true) {

	        int nextRow = row + dRow;
	        int nextCol = col + dCol;

	        if(nextRow < 0 || nextRow > 6 || nextCol < 0 || nextCol > 6) {
	            break;
	        }

	        row = nextRow;
	        col = nextCol;

	        if(grid[row][col].equals("W")) {

	            if(col == 0)
	                dCol = 1;
	            else if(col == 6)
	                dCol = -1;
	            else
	                break;
	        }

	        else if(bricks.containsKey(row + "," + col)) {
	            hitBrick(row,col);
	            break;
	        }
	    }

	    lives--;
	}
	
	private void hitBrick(int r,int c) {
		String key = r+","+c;
		
		int strength = bricks.get(key);
		strength--;
		if(strength==0) {
			bricks.remove(key);
			grid[r][c]=" ";
		}else {
			bricks.put(key, strength);
			grid[r][c]=String.valueOf(strength);
		}
	}
	
	public void startGame() {
		
		Scanner sc = new Scanner(System.in);
		while (lives>0 && bricks.size()>0) {
			
			printGrid();
			System.out.println("Enter Command(St,Lt,Rt)");
			
			String cmd = sc.nextLine();
			moveBall(cmd);
			
			System.out.println("Ball Count:"+lives);	
		}
		if(bricks.size()==0) {
			System.out.println("You Win !!!");
		}else {
			System.out.println("Game Over");
		}
		sc.close();
	}
}
