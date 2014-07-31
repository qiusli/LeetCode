package tree;

/**
 * Created by liqiushi on 7/31/14.
 * http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
 */
public class UniqueBinarySearchTree {
    public static void main(String[] args) {
        System.out.print(numTrees(3));
    }

    private static int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        return sum;
    }
}
