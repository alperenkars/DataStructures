package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;
import autograder.Util;

public class Sudoku implements Comparable<Sudoku>{
    
    public int[][] board;

    @Override
    public int compareTo(Sudoku o) {
        if(is_equal_to(o))
            return 0;
        else
            return 1;
    }

    public Sudoku makeCopy() {
        int[][] new_board = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                new_board[i][j] = board[i][j];
            }
        }
        return new Sudoku(new_board);
    }

    public Sudoku(int[][] board) {
        this.board = board;
    }

    public boolean is_equal_to(Sudoku s2) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(this.board[i][j] != s2.board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Use the three check_valid functions to make sure that every element of the board is in a valid row, column, and square, and there are no zeroes left on the board.
    public boolean check_if_solved() {
    	for(int k=0;k<board.length;k++) {
        	for(int a=0;a<board[k].length;a++) {
        		if(board[k][a]==0||!check_valid_in_row(k,a,board[k][a])||!check_valid_in_col(k,a,board[k][a])||!check_valid_in_square(k,a,board[k][a])) {
        			return false;
        		}
        	}
        }
    	return true;
    }

    // Given a specific location and value, return true if that value is valid for its row. Otherwise return false 
    public boolean check_valid_in_row(int row_num, int col_num, int value) {
    	//int count=0;
        for(int k:board[row_num]) {
        	if(k==value) {
        		return false;
        	}
        }
        return true;
    }

    // Given a specific location and value, return true if that value is valid for its column. Otherwise return false 
    public boolean check_valid_in_col(int row_num, int col_num, int value) {
        for(int[] a:board) {
        	if(a[col_num]==value) {
        		return false;
        	}
        	
        }
        return true;
    }

    // Helper function which will return an array of all elements in the square specified by the given row and column numbers
    private int[] get_values_in_square(int row_num, int col_num) {
        int row_start = ((int)(row_num / 3)) * 3;
        int col_start = ((int)(col_num / 3)) * 3;
        int[] values = new int[9];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(row_start + i == row_num && col_start + j == col_num)
                    values[i*3 + j] = -2;
                else
                    values[i*3 + j] = this.board[row_start + i][col_start + j];
            }
        }
        return values;
    }

    // Given a specific location and value, return true if that value is valid for its square. Otherwise return false.
    // You may use the helper function get_values_in_square to get the values in the corresponding square. 
    public boolean check_valid_in_square(int row_num, int col_num, int value) {
    	int[] a=get_values_in_square(row_num,col_num);
    		
    	
       for(int k:a) {
    	   if(k==value) {
    		   return false;
    	   }
       }
       return true;
    }

    // Return an array of two integers, corresponding to a (row, column) pair of the first location that there is a 0 at.
    // You should use row-major order, so that a row closer to the top of the board is considered to be earlier. For equal rows,
    // you can then check the columns. If there are no more open positions, return (-1, -1)
    public int[] get_first_open_position() {
    	
        for(int k=0;k<board.length;k++) {
        	for(int a=0;a<board[k].length;a++) {
        		if(board[k][a]==0) {
        			return new int[]{k, a};
        		}
        	}
        }
        return new int[]{-1, -1};
    }

    // We provide this toString method to aid with testing.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(1000);
        int num_sub = 0;
        for(int i = 0; i < 13; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 12) {
                for(int j = 0; j < 9; j++) {
                    if (j % 3 == 0) {
                        sb.append(" |");
                    }
                    sb.append(" ");
                    sb.append("-");
                }
                num_sub += 1;
            }
            else {
                for(int j = 0; j < 9; j++) {
                    if (j % 3 == 0) {
                        sb.append(" |");
                    }
                    sb.append(" ");
                    sb.append(new Integer(this.board[i-num_sub][j]));
                }
            }
            sb.append(" |");
            sb.append("\n");
        }
        return sb.toString();
    }
}