package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqiushi on 6/28/14.
 */
public class ThreeSum {
    public static void main(String[] args) {
//        int[] num = {-1, 0, 1, 2, -1, -4};
        int[] num = {-1, 0, 1};

        List<List<Integer>> result = threeSum(num);

        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> threeSum(int[] num) {
        if (num == null)
            return null;

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num.length < 3)
            return result;

        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] > num[i - 1]) {
                int target = -num[i];
                int front = num.length - 1, rear = i + 1;

                while (front > rear) {
                    while (front > rear && num[rear] + num[front] > target) {
                        front--;
                    }

                    while (front > rear && num[rear] + num[front] < target) {
                        rear++;
                    }

                    if (front > rear && num[rear] + num[front] == target) {
                        List<Integer> list = new ArrayList<Integer>();

                        list.add(num[i]);
                        list.add(num[rear]);
                        list.add(num[front]);

                        result.add(list);

                        rear++;
                        front--;
                        while (front > rear && num[rear] == num[rear - 1])
                            rear++;
                        while (front > rear && num[front] == num[front + 1])
                            front--;
                    }
                }
            }
        }
        return result;
    }
}
