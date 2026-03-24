package training;

import java.util.Scanner;

public class tictactoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][]= new char[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				grid[i][j]='1';
			}
		}
		print(grid);
		Scanner sc= new Scanner(System.in);
		boolean player1 =true;
		boolean play=true;
		while(play) {
			String crr=player1? "Player 1 ":"Player 2";
			System.out.println(crr+" enter index");
			int row=sc.nextInt();
			int col=sc.nextInt();
			if(!isValid(row, col, grid)) {
				System.out.println("Invalid index");
				continue;
			}
			char p="Player 1 "==crr?'x':'0';
			grid[row][col]=p;
			char w=win(grid,p);
			if(w=='d') {
				play=false;
				System.out.println("draw game");
			}
			if(p==w) {
				System.out.println(crr+" wins");
				play=false;
			}
			player1=!player1;
			print(grid);
		}
	}
	static void print(char[][] grid) {
		for(int i=0;i<3;i++) {
			System.out.print("| ");
			for(int j=0;j<3;j++) {
				if(grid[i][j]=='1') {
					System.out.print("  |");
				} else {
					System.out.print(grid[i][j]+" |");
				}
		}
		System.out.println();
		System.out.println("...........");
		}
	}
	public static boolean isValid(int row,int col, char[][] grid) {
		if(row>3||col>3) {
			return false;
		}
		if(grid[row][col]=='1') {
			return true;
		}
		return false;
	}
	public static char win(char[][] grid, char c) {
		int i=0,j=0;
		boolean w;
		for( i=0;i<3;i++) {
			w=true;
			for(j=0;j<3;j++) {
				if(grid[i][j]!=c) {
					w=false;
					break;
				}
			}
			if(w) {
				return c;
			}
		}
		
		for( i=0;i<3;i++) {
			w=true;
			for(j=0;j<3;j++) {
				if(grid[j][i]!=c) {
					w=false;
					break;
				}
			}
			if(w) {
				return c;
			}
		}
		i=0;j=0;
		w=true;
		while(i<3&&j<3) {
			if(grid[i][j]!=c) {
				w=false;
				break;
			}
			i++;j++;
		}
		if(w) {
			return c;
		}
		w=true;
		i=0;j=2;
		while(i<3&&j>=0) {
			if(grid[i][j]!=c) {
				w=false;
				break;
			}
			i++;j--;
		}
		if(w) {
			return c;
		}
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				if(grid[i][j]=='1') {
					return 'c';
				}
			}
		}
		return 'd';
	}
}
