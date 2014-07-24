package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqiushi on 6/29/14.
 */
public class FourSum {
    public static void main(String[] args) {
//        int[] num = {1, 0, 0, -2, -1, 2};
        int[] num = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = fourSum(num, -1);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num == null)
            return null;

        if (num.length < 4)
            return result;

        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i == 0 || num[i] > num[i - 1]) {
                for (int j = i + 1; j < num.length - 2; j++) {
                    if (j == i + 1|| num[j] > num[j - 1]) {
                        int front = num.length - 1, rear = j + 1;

                        while (front > rear) {
                            int sum = num[i] + num[j] + num[rear] + num[front];
                            while (front > rear && sum < target) {
                                rear++;
                                sum = num[i] + num[j] + num[rear] + num[front];
                            }

                            while (front > rear && sum > target) {
                                front--;
                                sum = num[i] + num[j] + num[rear] + num[front];
                            }

                            if (front > rear && sum == target) {
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(num[i]);
                                list.add(num[j]);
                                list.add(num[rear]);
                                list.add(num[front]);

                                result.add(list);

                                rear++;
                                front--;
                                while (rear < front && num[rear] == num[rear - 1]) {
                                    rear++;
                                }

                                while (rear < front && num[front + 1] == num[front]) {
                                    front--;
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
