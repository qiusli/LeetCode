package sorting;

/**
 * Created by liqiushi on 8/4/14.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] A = {2, 0, 1, 2, 1, 1, 0, 1};
        int[] B = {2, 0};
        int[] C = {0, 0};
        int[] D = {0, 0, 1, 1, 2};
        int[] E = {0, 0, 1, 1, 2, 2, 1, 0, 1, 2, 0, 0, 0};
        sortColors(A);
        sortColors(B);
        sortColors(C);
        sortColors(D);
        sortColors(E);
    }

    private static void sortColors(int[] A) {
        if (A == null)
            return;

        int rear_ptr = 0, front_ptr = A.length - 1;
        for (int i = 0; i < A.length && rear_ptr < front_ptr; ) {
            if (A[i] == 0) {
                if (i == rear_ptr) {
                    i++;
                    rear_ptr++;
                } else {
                    swap(A, i, rear_ptr++);
                }
            } else if (A[i] == 2) {
                if (i < front_ptr)
                    swap(A, i, front_ptr--);
                else
                    i++;
            } else {
                i++;
            }
        }

        for (int i : A)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
