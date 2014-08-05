package searching;

/**
 * Created by liqiushi on 8/4/14.
 */
public class SearchForARange {
    public static void main(String[] args) {
        int[] A = {5, 7, 8, 8, 10};
        int[] result = searchRange(A, 8);
        System.out.println(result[0] + " " + result[1]);

        int[] B = {1, 3, 5, 7, 9};
        int[] result2 = searchRange(B, 8);
        System.out.println(result2[0] + " " + result2[1]);

        int[] C = {1, 3, 5, 7, 9};
        int[] result3 = searchRange(C, 5);
        System.out.println(result3[0] + " " + result3[1]);
    }

    private static int[] searchRange(int[] A, int target) {
        if (A == null)
            return new int[]{-1, -1};

        // r[0]存放的是左边的最小下标, r[1]存放的是右边的最大下标
        int[] r = new int[2];
        r[0] = Integer.MAX_VALUE;
        r[1] = Integer.MIN_VALUE;
        search(A, target, 0, A.length - 1, r);

        return r[0] == Integer.MAX_VALUE && r[1] == Integer.MIN_VALUE ? new int[]{-1, -1} : r;
    }

    private static void search(int[] A, int target, int start, int end, int[] r) {
        if (start >= end) {
            if (A[start] == target && start < r[0])
                r[0] = start;

            if (A[start] == target && start > r[1])
                r[1] = start;

            return;
        }

        int mid = (start + end) / 2;
        search(A, target, start, mid, r);
        search(A, target, mid + 1, end, r);
    }
}
