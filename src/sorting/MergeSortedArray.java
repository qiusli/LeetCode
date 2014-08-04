package sorting;

/**
 * Created by liqiushi on 8/3/14.
 * http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0, 0};
        int[] B = {2, 4, 6, 8, 10};
        merge(A, A.length, B, B.length);
    }

    private static void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null)
            return;

        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (j < 0 || i >= 0 && A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
    }
}
