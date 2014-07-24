package array;

/**
 * Created by liqiushi on 7/2/14.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] num = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(num));
    }

    private static int trap(int[] A) {
        if (A == null)
            return -1;

        int water = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int l = i - 1, lb = A[l], r = i + 1, rb = A[r];
            while (l >= 0) {
                if (A[l] > lb)
                    lb = A[l];
                l--;
            }
            while (r < A.length) {
                if (A[r] > rb)
                    rb = A[r];
                r++;
            }

            if (Math.min(lb, rb) > A[i])
                water += Math.min(lb, rb) - A[i];
        }

        return water;
    }
}
