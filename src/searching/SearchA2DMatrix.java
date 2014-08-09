package searching;

/**
 * Created by liqiushi on 8/5/14.
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 1));
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 7));
        System.out.println(searchMatrix(matrix, 10));
        System.out.println(searchMatrix(matrix, 11));
        System.out.println(searchMatrix(matrix, 16));
        System.out.println(searchMatrix(matrix, 20));
        System.out.println(searchMatrix(matrix, 23));
        System.out.println(searchMatrix(matrix, 30));
        System.out.println(searchMatrix(matrix, 34));
        System.out.println(searchMatrix(matrix, 50));
        System.out.println(searchMatrix(matrix, 15));
        System.out.println(searchMatrix(matrix, 99));
        System.out.println(searchMatrix(matrix, 111));
        System.out.println(searchMatrix(matrix, 112));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;

        int row = searchRow(matrix, target, 0, matrix.length - 1);
        int column = searchColumn(matrix[row], target, 0, matrix[row].length - 1);

        return matrix[row][column] == target;
    }

    private static int searchColumn(int[] matrix, int target, int start, int end) {
        if (start >= end)
            return start;

        int mid = (start + end) / 2;
        if (target < matrix[mid])
            return searchColumn(matrix, target, start, mid - 1);
        else if (target > matrix[mid])
            return searchColumn(matrix, target, mid + 1, end);
        else
            return mid;
    }

    private static int searchRow(int[][] matrix, int target, int start, int end) {
        if (start >= end)
            return start;

        int mid = (start + end) / 2;
        if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length - 1])
            return mid;
        else if (target < matrix[mid][0])
            return searchRow(matrix, target, start, mid - 1);
        else
            return searchRow(matrix, target, mid + 1, end);
    }
}
