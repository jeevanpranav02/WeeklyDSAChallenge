package Day_6;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(totalNQueens(n));
	}
	
	
	public static int totalNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		return helperCount(board, 0);
	}
	
	
	private static int  helperCount(char[][] board,int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board.length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 'Q';
				count += helperCount(board, row + 1);
				board[row][col] = '.';
			}
		}
		return count;
	}

	public static List<List<String>> solveNQueens(int n) {
		//Creating a list to return the result
		List<List<String>> list = new ArrayList<>();
		
		//Initially a char 2D array is made so that the number of paths can be marked
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		
		//Function is called
		helperList(list,board, 0);
		return list;
	}

	public static void helperList(List<List<String>> list ,char[][] board, int row) {
		//When the row reaches the board's length(n) the function adds the result to the list
		if (row == board.length) {
			List<String> tempList = new ArrayList<>();
			// Character array is converted to string and added to list
			convetToList(board, tempList);
			list.add(tempList);;
			return;
		}

		//Here we are traversing each column to find the safe place for queen
		for (int col = 0; col < board.length; col++) {
			if (isSafe(board, row, col)) {
				//When the place is safe then the queen is placed
				board[row][col] = 'Q';
				
				//Recursion call to check safe place to place the queen for the next row
				helperList(list,board, row + 1);
				
				//Backtracking occurs
				board[row][col] = '.';
			}
		}

	}

	private static boolean isSafe(char[][] board, int row, int col) {
		
		// Check each row for queen
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}

		// Check each column for queen
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 'Q') {
				return false;
			}
		}

		// Check left diagonal for queen
		int maxLeft = Math.min(row, col);
		for (int i = 1; i <= maxLeft; i++) {
			if (board[row - i][col - i] == 'Q') {
				return false;
			}
		}

		// Check right diagonal for queen
		int maxRight = Math.min(row, board.length - col - 1);
		for (int i = 1; i <= maxRight; i++) {
			if (board[row - i][col + i] == 'Q') {
				return false;
			}
		}
		
		//When all the diagonals, rows and columns are safe then it is safe to place the queen in that position
		return true;
	}

	private static void convetToList(char[][] board, List<String> temp) {
		for (char[] str : board) {
			temp.add(String.valueOf(str));
		}
	}
}
