package greedy;

/**
 * Created by liqiushi on 8/16/14.
 */
public class JumpGameII {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 4};
        System.out.println(jump(A));

        int[] B = {3, 2, 1, 0, 4};
        System.out.println(jump(B));

        int[] C = {30, 0, 0};
        System.out.println(jump(C));

        int[] D = {2, 5, 0, 0};
        System.out.println(jump(D));

        int[] E = {2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5,
                3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7,
                9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9,
                4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6};
        System.out.println(jump(E));

        int[] F = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(F));
    }

    private static int jump(int[] A) {
        if (A == null)
            return -1;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            int tmp = i;
            int step = 0;
            while (tmp < A.length - 1 && A[tmp] != 0) {
                tmp = tmp + A[tmp];
                step++;
            }
            if (A[tmp] != 0 && step < min) {
                min = step;
            }
        }

        return min;
    }
}
