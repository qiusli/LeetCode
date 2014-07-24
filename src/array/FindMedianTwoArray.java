package array;

/**
 * Created by liqiushi on 6/23/14.
 */
public class FindMedianTwoArray {
    public static void main(String[] args) {
//        int[] m = {1, 3, 4, 6, 7, 10, 12};
//        int[] n = {2, 5, 8, 9, 11};

        int[] m = {2, 3, 4};
        int[] n = {1};
        System.out.println(findMedianSortedArrays(m, n));
    }

    // log(m+n)
    public static double findMedianSortedArrays(int A[], int B[]) {
        double result;
        int lenA = A.length, lenB = B.length;
        if ((lenA + lenB) % 2 != 0) {
            result = findKth(A, B, (lenA + lenB) / 2, 0, lenA - 1, 0, lenB - 1);
        } else {
            result = (findKth(A, B, (lenA + lenB) / 2, 0, lenA - 1, 0, lenB - 1) +
                    findKth(A, B, (lenA + lenB) / 2 - 1, 0, lenA - 1, 0, lenB - 1)) / 2;
        }
        return result;
    }

    private static double findKth(int[] A, int[] B, int k, int startA, int endA, int startB, int endB) {
        int lenA = endA - startA + 1, lenB = endB - startB + 1;

        if (lenA == 0)
            return B[startB + k];

        if (lenB == 0)
            return A[startA + k];

        if (k == 0)
            return A[startA] > B[startB] ? B[startB] : A[startA];

        // to calculate the ratio is to guarantee that k >= (idxA - startA + 1)
        int idxA = startA + lenA * k / (lenA + lenB), idxB = startB + k - (idxA - startA + 1);

        if (A[idxA] < B[idxB]) {
            k -= (idxA - startA + 1);
            return findKth(A, B, k, idxA + 1, endA, startB, idxB);
        } else {
            k -= (idxB - startB + 1);
            return findKth(A, B, k, startA, idxA, idxB + 1, endB);
        }
    }
}
