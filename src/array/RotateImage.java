package array;

/**
 * Created by liqiushi on 7/3/14.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {1, 2, 3, 4},
                {5, 6, 7, 8},
        };
        rotate(matrix);
    }

    private static void rotate(int[][] matrix) {
        if (matrix == null)
            return;
        // times to rotate
        // execute a circle / time
        int r_a = 0, r_b = 0, r_c = matrix.length - 1, r_d = matrix.length - 1;
        int c_a = 0, c_b = matrix.length - 1, c_c = matrix.length - 1, c_d = 0;

        for (int i = 0; i < matrix.length / 2; i++) {
            int t_r_a = r_a, t_r_b = r_b, t_r_c = r_c, t_r_d = r_d;
            int t_c_a = c_a, t_c_b = c_b, t_c_c = c_c, t_c_d = c_d;
            while (t_c_a < matrix.length - 1 - i) {
                int tmp = matrix[t_r_a][t_c_a];
                matrix[t_r_a][t_c_a] = matrix[t_r_d][t_c_d];
                matrix[t_r_d][t_c_d] = matrix[t_r_c][t_c_c];
                matrix[t_r_c][t_c_c] = matrix[t_r_b][t_c_b];
                matrix[t_r_b][t_c_b] = tmp;

                t_c_a++;
                t_r_b++;
                t_c_c--;
                t_r_d--;
            }
            r_a++;
            r_b++;
            r_c--;
            r_d--;

            c_a++;
            c_b--;
            c_c--;
            c_d++;
        }
        System.out.print("");
    }
}
