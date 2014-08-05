package sorting;

/**
 * Created by liqiushi on 8/4/14.
 * http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
 */
public class FindMissingPositive {
    public static void main(String[] args) {
        int[] A = {3, 4, -1, 1};
        int[] B = {1, 2, 4, 5};
        int[] C = {1, 0};
        int[] D = {1, 1};
        System.out.println(firstMissingPositive(A));
        System.out.println(firstMissingPositive(B));
        System.out.println(firstMissingPositive(C));
        System.out.println(firstMissingPositive(D));
    }

    private static int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)
            return 1;

        for (int i = 0; i < A.length; ) {
            // 把当前元素移动到它应该存在的地方去(e.g. 3移动到A[2]上去)
            if (A[i] > 0 && A[i] <= A.length && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
                int tmp = A[i];
                A[i] = A[A[i] - 1];
                A[tmp - 1] = tmp;
            } else {
                i++;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A[A.length - 1] + 1;
    }
}
