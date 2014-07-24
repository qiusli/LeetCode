package array;

/**
 * Created by liqiushi on 6/22/14.
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
//        int[] A = {1, 1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9};
        int[] A = {1, 1, 2};
        int l = remove(A);
        System.out.println("length : " + l);
    }

    private static int remove(int[] A) {
        if (A == null)
            return -1;

        if (A.length == 0)
            return 0;

        int rear = 0, front = 1;
        while (front < A.length) {
            if (A[rear] != A[front]) {
                rear++;
                A[rear] = A[front];
            }
            front++;
        }

        return rear + 1;
    }
}
