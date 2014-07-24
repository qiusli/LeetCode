package array;

import java.util.Arrays;

/**
 * Created by liqiushi on 6/28/14.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
//        int[] num = {-1, 0, 1, 2, -1, -4};
        int[] num = {1, 1, 1, 0};
        System.out.println(threeSumClosest(num, -100));
    }

    private static int threeSumClosest(int[] num, int target) {
        if (num == null)
            return Integer.MIN_VALUE;

        if (num.length < 3)
            return Integer.MIN_VALUE;

        Arrays.sort(num);
        int closestDiff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++)  {
            int front = num.length - 1, rear = i + 1;
            while (front > rear) {
                int sum = num[i] + num[rear] + num[front];
                int curDiff = Math.abs(sum - target);

                if (curDiff < closestDiff) {
                    closestDiff = curDiff;
                    result = sum;
                }

                if (sum > target)
                    front--;
                else
                    rear++;
            }
        }

        return result;
    }
}
