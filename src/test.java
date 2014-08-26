/**
 * Created by liqiushi on 8/18/14.
 */
public class test {
public double findMedianSortedArrays(int A[], int B[]) {
    if (A == null && B == null)
        return Double.MIN_VALUE;

    if (A.length == 0 && B.length == 0)
        return Double.MIN_VALUE;

    int totalLength = A.length + B.length;

    if ((totalLength & 0x1) != 0)
        return findMedian(A, 0, A.length, B, 0, B.length, totalLength / 2 + 1);
    else
        return (findMedian(A, 0, A.length, B, 0, B.length, totalLength / 2)
                + findMedian(A, 0, A.length, B, 0, B.length, totalLength / 2 + 1)) / 2.0;
}


private double findMedian(int[] A, int startA, int endA, int[] B, int startB, int endB, int kValue) {
    if (startA >= endA)
        return B[startB + kValue - 1];
    if (startB >= endB)
        return A[startA + kValue - 1];

    if (kValue <= 1)
        return Math.min(A[startA], B[startB]);

    int midA = (endA - startA) / 2;
    int midB = (endB - startB) / 2;

    if (A[startA + midA] > B[startB + midB]) {
        if ((midA + midB) >= kValue - 1)
            return findMedian(A, startA, startA + midA, B, startB, endB, kValue);
        else
            return findMedian(A, startA, endA, B, startB + midB + 1, endB, kValue - midB - 1);
    } else {
        if ((midA + midB) >= kValue - 1)
            return findMedian(A, startA, endA, B, startB, startB + midB, kValue);
        else
            return findMedian(A, startA + midA + 1, endA, B, startB, endB, kValue - midA - 1);
    }
}
}
