package searching;

/**
 * Created by liqiushi on 8/5/14.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6};
        System.out.println(searchInsert(A, 5));
        System.out.println(searchInsert(A, 2));
        System.out.println(searchInsert(A, 7));
        System.out.println(searchInsert(A, 0));

        int[] B = {1};
        System.out.println(searchInsert(B, 1));
    }

    private static int searchInsert(int[] A, int target) {
        if (A == null)
            return -1;

        return search(A, target, 0, A.length - 1);
    }

    private static int search(int[] A, int target, int start, int end) {
        if (start >= end) {
            // 从前面开始插，即[1] 1 时返回0
            if (A[start] == target || target < A[start])
                return start;
            else
                return start + 1;
        }

        int mid = (start + end) / 2;
        if (A[mid] > target) {
            return search(A, target, start, mid - 1);
        } else if (A[mid] < target) {
            return search(A, target, mid + 1, end);
        } else {
            return mid;
        }
    }
}
