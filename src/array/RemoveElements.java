package array;

/**
 * Created by liqiushi on 6/29/14.
 */
public class RemoveElements {
    public static void main(String[] args) {
        int[] A = {0, 0, -2, 2, -1, 1};
//        int[] A = {4, 5};
        System.out.print(removeElement(A, 0));
    }

    private static int removeElement(int[] A, int elem) {
        if (A == null)
            return -1;

        if (A.length == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem)
                A[count++] = A[i];
        }

        return count;
    }
}
