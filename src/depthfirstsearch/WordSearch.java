package depthfirstsearch;

/**
 * Created by liqiushi on 8/12/14.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(exist(board, "ABFD"));
        System.out.println(exist(board, "ABFF"));
        System.out.println(exist(board, "SFBC"));
        System.out.println(exist(board, "ADEE"));
        System.out.println(exist(board, "ADEC"));
        System.out.println(exist(board, "ADEF"));
        System.out.println(exist(board, "EECS"));

        char[][] board2 = {
                {'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A'}};
        System.out.println(exist(board2, "AAAAAAAAAAAB"));
    }

    private static boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.trim().length() == 0)
            return false;

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++)
            for (int j = 0; j < visited[i].length; j++)
                visited[i][j] = false;

        int start = 0;
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[r].length; c++)
                if (dfs(board, start, r, c, visited, word))
                    return true;

        return false;
    }

    private static boolean dfs(char[][] board, int start, int row, int column, boolean[][] visited, String word) {
        if (start == word.length())
            return true;

        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length)
            return false;

        if (visited[row][column])
            return false;

        if (board[row][column] != word.charAt(start))
            return false;

        visited[row][column] = true;
        boolean res = dfs(board, start + 1, row - 1, column, visited, word) ||
                dfs(board, start + 1, row, column - 1, visited, word) ||
                dfs(board, start + 1, row + 1, column, visited, word) ||
                dfs(board, start + 1, row, column + 1, visited, word);
        visited[row][column] = false;

        return res;
    }
}
