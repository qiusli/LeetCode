package brutalforce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/6/14.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        List<List<Integer>> result = permute(num);
        for (List list : result) {
            for (int i = 0; i < list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }

    private static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null)
            return result;

        permute(num, result, 0);
        return result;
    }

    private static void permute(int[] num, List<List<Integer>> result, int start_index) {
        if (start_index == num.length) {
            result.add(convertToList(num));
            return;
        }

        for (int i = start_index; i < num.length; i++) {
            swap(num, i, start_index);
            permute(num, result, start_index + 1);
            swap(num, i, start_index);
        }
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private static List<Integer> convertToList(int[] num) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i : num)
            res.add(i);
        return res;
    }
}
