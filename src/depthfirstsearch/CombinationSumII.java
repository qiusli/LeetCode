package depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqiushi on 8/11/14.
 */
public class CombinationSumII {
    public static void main(String... args) {
        int[] num = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = combinationSum2(num, 8);
        for (List<Integer> list : res) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    private static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null)
            return res;

        Arrays.sort(num);
        List<Integer> subs = new ArrayList<Integer>();
        // as I sort the array and should stop immediately when curSum >= target since the rest of the elements been
        // added are definitely larger than the target
        boolean[] stopSearchin = new boolean[1];
        stopSearchin[0] = false;
        backTrack(num, 0, 0, target, subs, res, stopSearchin);
        return res;
    }

    private static void backTrack(int[] num, int start, int curSum, int target, List<Integer> subs,
                                  List<List<Integer>> res, boolean[] stopSearchin) {
        if (curSum >= target) {
            stopSearchin[0] = true;
            if (curSum == target) {
                List<Integer> list = new ArrayList<Integer>(subs);
                if (!res.contains(list))
                    res.add(list);
            }
            return;
        }

        for (int i = start; i < num.length; i++) {
            subs.add(num[i]);
            backTrack(num, i + 1, curSum + num[i], target, subs, res, stopSearchin);
            subs.remove(subs.size() - 1);
            if (stopSearchin[0]) {
                stopSearchin[0] = false;
                return;
            }
        }
    }
}
