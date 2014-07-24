package array;

import java.util.Arrays;

/**
 * Created by liqiushi on 6/29/14.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] num = {1, 3, 2};
//        int[] num = {3, 2, 1};
        nextPermutation(num);
    }

    private static void nextPermutation(int[] num) {
        if (num == null)
            return;

        if (num.length < 2)
            return;

        int chgIndex = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                chgIndex = i - 1;
                break;
            }
        }

        if (chgIndex == -1) {
            Arrays.sort(num);
            return;
        }

        for (int i = num.length - 1; i > chgIndex; i--) {
            if (num[i] > num[chgIndex]) {
                int tmp = num[chgIndex];
                num[chgIndex] = num[i];
                num[i] = tmp;

                break;
            }
        }

        int rear = chgIndex + 1;
        int front = num.length - 1;
        while (front > rear) {
            int tmp = num[front];
            num[front] = num[rear];
            num[rear] = tmp;

            front--;
            rear++;
        }
    }
}
