package brutalforce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/7/14.
 * http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] num = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(num);
        for (List list : result) {
            for (int i = 0; i < list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }

    private static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null)
            return result;

        permute(num, result, 0);
        return result;
    }

    private static void permute(int[] num, List<List<Integer>> result, int index) {
        if (index == num.length) {
            List<Integer> tmp = convertToList(num);
            result.add(tmp);
            return;
        }

        for (int i = index; i < num.length; i++) {
            if (!visited(num, index, i)) {
                swap(num, i, index);
                permute(num, result, index + 1);
                swap(num, i, index);
            }
        }
    }

    private static boolean visited(int[] num, int index, int end) {
        for (int i = index; i <= end - 1; i++) {
            if (num[i] == num[end]) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> convertToList(int[] num) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i : num)
            res.add(i);
        return res;
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
