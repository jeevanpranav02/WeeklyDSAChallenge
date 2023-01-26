package Day_7;

import java.util.Arrays;

public class SudukoSolver {
	public static void main(String[] args) {
		char[][] board = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '3', '.', '.', '6', '.', '.', '.', '.' },
				{ '4', '3', '.', '8', '.', '3', '.', '.', '.' },
				{ '7', '3', '.', '.', '2', '.', '.', '.', '.' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }
				};
		System.out.println("Before Solving suduko : ");
		for (char[] cs : board) {
			System.out.println(Arrays.toString(cs));
		}
		System.out.println();
		solveSudoku(board);
		System.out.println("After Solving suduko : ");
		for (char[] cs : board) {
			System.out.println(Arrays.toString(cs));
		}
	}

	static void solveSudoku(char[][] board) {
		solve(board);
	}
	
	static boolean solve(char[][] board) {
		
		int row = -1;
		int col = -1;
		
		boolean emptyLeft = true;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == '.') {
					row = i;
					col = j;
					emptyLeft = false;
					break;
				}
			}
			if(emptyLeft == false) {
				break;
			}
		}
		
		if(emptyLeft == true) {
			return true;
		}
		
		for(char num = '1'; num <= '9'; num++) {
			if(isSafe(board, row, col, num)) {
				board[row][col] = num;
				if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
			}
		}
		return false;
	}
	
	static boolean isSafe(char[][] board, int row, int col, char num) {
		//Checking Row
		for (int i = 0; i < board.length; i++) {
			if(board[row][i] == num) {
				return false;
			}
		}
		
		//Checking Column
		for (char[] nums : board) {
			if(nums[col] == num) {
				return false;
			}
		}
		
		//Checking grid
		int squareRoot = (int) Math.sqrt(board.length);
		int start = row - row % squareRoot;
		int end = col - col % squareRoot;
		
		for (int i = start; i < start + squareRoot; i++) {
			for (int j = end; j < end + squareRoot; j++) {
				if(board[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
}
