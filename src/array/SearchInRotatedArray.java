package array;

/**
 * Created by liqiushi on 6/23/14.
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
//        int[] A = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] A = {3, 1};
        int index = search(A, 1);
        System.out.println(index);
    }

    private static int search(int[] A, int target) {
        if (A == null)
            return -1;

        if (A.length == 0)
            return -1;

        int low = 0, high = A.length;

        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (A[mid] == target)
                return mid;

            if (A[low] < A[mid]) {
                if (A[low] <= target && target < A[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[high - 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return -1;
    }
}
