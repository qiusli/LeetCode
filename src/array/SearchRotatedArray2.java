package array;

/**
 * Created by liqiushi on 6/23/14.
 */
public class SearchRotatedArray2 {
    public static void main(String[] args) {
//        int[] A = {4, 4, 5, 6, 7, 0, 1, 2, 3};
//        int[] A = {1, 1, 1, 3, 1};
        int[] A = {1, 3, 1, 1};
        boolean index = search(A, 3);
        System.out.println(index);
    }

    private static boolean search(int[] A, int target) {
        if (A == null)
            return false;

        if (A.length == 0)
            return false;

        int low = 0, high = A.length;

        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (A[mid] == target)
                return true;

            if (A[low] < A[mid]) {
                if (A[low] <= target && target < A[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else if (A[low] > A[mid]) {
                if (A[mid] < target && target <= A[high - 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else {
                low++;
            }
        }

        return false;
    }
}
