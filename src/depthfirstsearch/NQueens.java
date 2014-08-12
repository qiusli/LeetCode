package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/10/14.
 */
public class NQueens {
    public static void main(String[] args) {
        List<String[]> res = solveNQueens(8);
        for (String[] s : res) {
            for (String str : s) {
                System.out.print(str + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    private static List<String[]> solveNQueens(int n) {
        if (n == 0)
            return null;

        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }
        List<String[]> res = new ArrayList<String[]>();
        backTrack(0, board, res);
        return res;
    }

    private static void backTrack(int c, char[][] board, List<String[]> res) {
        if (c == board.length) {
            String[] strings = new String[board.length];
            for (int i = 0; i < board.length; i++) {
                String str = "";
                for (int j = 0; j < board[i].length; j++) {
                    str += board[i][j];
                }
                strings[i] = str;
            }
            res.add(strings);
            return;
        }

        for (int r = 0; r < board.length; r++) {
            if (!threaten(board, r, c)) {
                board[r][c] = 'Q';
                backTrack(c + 1, board, res);
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
