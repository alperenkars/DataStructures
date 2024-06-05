package code;

public class SudokuSolver {

    /*
     * Solving the board can be considered a breadth-first search problem or a depth-first search problem, where each combination of
     * numbers on a board is considered a node, and there is a (directed) edge between two boards if you can 
     * go from one board to another by adding a single (valid) number.
     * In this way, given an initial board state, and using the helper methods you wrote for the Sudoku class,
     * write the algorithm to solve the sudoku board.
     * You are free to add any fields or methods you need, but do not modify the method signature of the solveSudokuBoard method.
     * WARNING: There are approximate 6 x 10^21 possible boards of Sudoku. You should be careful in how you add and keep track of
     * new boards, otherwise you can very quickly run out of memory on your computer, or get very slow performance. 
     * While we will not be grading you based on the speed of the algorithm, we do expect that you are able to solve a board 
     * in less than a second, since the Autograder will be checking against more than 60 boards.
     */
    public Sudoku solveSudokuBoard(Sudoku currentBoard) {
    	
        solveDFS(0,0,currentBoard.board.length,currentBoard);
        return currentBoard;
    }

    private boolean solveDFS(int row, int col, int boardsize, Sudoku sud) {
        // Base case for recursive DFS
        if (row == boardsize) {
            return true;
        }

        // If reached the end of a row, move to the next row
        if (col == boardsize) {
            return solveDFS(row + 1, 0,boardsize,sud);
        }

        // Skip the cell if filled
        if (sud.board[row][col] != 0) {
            return solveDFS(row, col + 1,boardsize,sud);
        }

      
        for (int num = 1; num <= 9; num++) {
            if (sud.check_valid_in_row(row,col,num)&&sud.check_valid_in_col(row,col,num)&&sud.check_valid_in_square(row,col,num)) {
                sud.board[row][col] = num;

                if (solveDFS(row, col + 1,boardsize,sud)) {
                    return true;
                }

                //set it equal to zero if false
                sud.board[row][col] = 0;
            }
        }

        return false;
    }

}
