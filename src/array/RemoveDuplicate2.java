package array;

/**
 * Created by liqiushi on 6/23/14.
 */
public class RemoveDuplicate2 {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 2, 3};
        int l = removeDuplicates(A);
        System.out.println("length : " + l);
    }

    private static int removeDuplicates(int[] A) {
        if (A == null)
            return -1;

        if (A.length == 0 || A.length == 1)
            return A.length;

        int rear = 0, front = 1, counter = 1;
        while (front < A.length) {
            if (A[rear] != A[front]) {
                rear++;
                A[rear] = A[front];
                counter = 1;
            } else {
                if (counter < 2) {
                    counter++;
                    rear++;
                    A[rear] = A[front];
                }
            }

            front++;
        }

        return rear + 1;
    }

    private static int removeDuplicates_2(int[] A) {
        if (A.length <= 2)
            return A.length;

        int prev = 1; // point to previous
        int curr = 2; // point to current

        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }

        return prev + 1;
    }
}
