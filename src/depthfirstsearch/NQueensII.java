package depthfirstsearch;

/**
 * Created by liqiushi on 8/11/14.
 */
public class NQueensII {
    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }

    private static int totalNQueens(int n) {
        if (n == 0)
            return 0;

        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }
        int[] num = new int[1];
        num[0] = 0;
        backTrack(0, board, num);
        return num[0];
    }

    private static void backTrack(int c, char[][] board, int[] num) {
        if (c == board.length) {
            num[0] += 1;
            return;
        }

        for (int r = 0; r < board.length; r++) {
            if (!threaten(board, r, c)) {
                board[r][c] = 'Q';
                backTrack(c + 1, board, num);
                board[r][c] = '.';
            }
        }
    }

    private static boolean threaten(char[][] board, int r, int c) {
        // same row
        int a = r, b = 0;
        while (b < board[a].length) {
            if (board[a][b] == 'Q' && b != c)
                return true;
            b++;
        }

        // same column
        a = 0;
        b = c;
        while (a < board.length) {
            if (board[a][b] == 'Q' && a != r)
                return true;
            a++;
        }

        // upper left
        a = r;
        b = c;
        while (a >= 0 && b >= 0) {
            if (board[a][b] == 'Q')
                return true;
            a--;
            b--;
        }

        // bottom left
        a = r;
        b = c;
        while (a < board.length && b >= 0) {
            if (board[a][b] == 'Q')
                return true;
            a++;
            b--;
        }

        // upper right
        a = r;
        b = c;
        while (a >= 0 && b < board[0].length) {
            if (board[a][b] == 'Q')
                return true;
            a--;
            b++;
        }

        // bottom right
        a = r;
        b = c;
        while (a < board.length && b < board[0].length) {
            if (board[a][b] == 'Q')
                return true;
            a++;
            b++;
        }
        return false;
    }
}
