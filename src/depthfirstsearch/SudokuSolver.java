package depthfirstsearch;

/**
 * Created by liqiushi on 8/12/14.
 */
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '6', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }

    private static void solveSudoku(char[][] board) {
        if (board == null)
            return;

        int row = 0, column = 0;
        dfs(board, row, column);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // top to bottom & left to right
    private static boolean dfs(char[][] board, int r, int c) {
        if (r == 9)
            return true;

        // return here and line 57 is because you will backtrack to the very beginning once a solution is found
        if (c == 9)
            return dfs(board, r + 1, 0);

        if (board[r][c] == '.') {
            // try each number
            for (int k = 1; k <= 9; k++) {
                board[r][c] = Character.forDigit(k, 10);
                if (isValid(board, r, c)) {
                    // when find the solution should return true to avoid any more backtrack search
                    if (dfs(board, r, c + 1))
                        return true;
                }
                board[r][c] = '.';
            }
        } else {
            return dfs(board, r, c + 1);
        }
        return false;
    }

    private static boolean isValid(char[][] board, int r, int c) {
        // check row
        for (int k = 0; k < board.length; k++)
            if (k != r && board[r][c] == board[k][c])
                return false;

        // check column
        for (int k = 0; k < board.length; k++)
            if (k != c && board[r][c] == board[r][k])
                return false;

        // check square
        for (int x = r / 3 * 3; x < r / 3 * 3 + 3; x++)
            for (int y = c / 3 * 3; y < c / 3 * 3 + 3; y++)
                if ((x != r || y != c) && board[x][y] == board[r][c])
                    return false;

        return true;
    }
}
