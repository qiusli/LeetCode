package greedy;

/**
 * Created by liqiushi on 8/15/14.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 4};
        System.out.println(canJump(A));

        int[] B = {3, 2, 1, 0, 4};
        System.out.println(canJump(B));

        int[] C = {30, 0, 0};
        System.out.println(canJump(C));

        int[] D = {2, 5, 0, 0};
        System.out.println(canJump(D));

        int[] E = {2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5,
                3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7,
                9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9,
                4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6};
        System.out.println(canJump(E));
    }

    private static boolean canJump(int[] A) {
        if (A == null)
            return false;

        int max_idx_can_achieve = 0;
        for (int i = 0; max_idx_can_achieve < A.length - 1 && i <= max_idx_can_achieve; i++) {
            if (i + A[i] > max_idx_can_achieve)
                max_idx_can_achieve = i + A[i];
        }

        return max_idx_can_achieve >= A.length - 1;
    }

    // Time Limit Exceeded
    private static boolean find(int[] A, int start) {
        if (start >= A.length - 1)
            return true;

        if (A[start] != 0)
            for (int i = start + 1; i <= start + A[start]; i++) {
                if (find(A, i))
                    return true;
            }
        else
            return start >= A.length - 1;

        return false;
    }
}
