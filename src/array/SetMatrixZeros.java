package array;

import java.util.Stack;

/**
 * Created by liqiushi on 7/4/14.
 */
public class SetMatrixZeros {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {0, 5, 6, 7},
//                {9, 10, 11, 0},
//                {12, 13, 14, 15}
//        };
        int[][] matrix = {{0}};
        setZeroes(matrix);
    }

    private static void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;

        Stack<Integer> row = new Stack<Integer>();
        Stack<Integer> column = new Stack<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.push(i);
                    column.push(j);
                }
            }
        }

        while (row.size() > 0) {
            int r = row.pop();
            int c = column.pop();

            int tr = r;
            // go up
            while (tr >= 0) {
                matrix[tr][c] = 0;
                tr--;
            }

            // go down
            tr = r;
            while (tr < matrix.length) {
                matrix[tr][c] = 0;
                tr++;
            }

            // go left
            int tc = c;
            while (tc >= 0) {
                matrix[r][tc] = 0;
                tc--;
            }

            // go right
            tc = c;
            while (tc < matrix[0].length) {
                matrix[r][tc] = 0;
                tc++;
            }
        }

        System.out.print("");
    }
}
