package depthfirstsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liqiushi on 8/11/14.
 */
public class CombinationSum {
    public static void main(String... args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> res = combinationSum(candidates, 7);
        for (List<Integer> list : res) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null)
            return res;

        List<Integer> subs = new ArrayList<Integer>();
        backTrack(candidates, 0, target, subs, res);
        return res;
    }

    private static void backTrack(int[] candidates, int curSum,
                                  int target, List<Integer> subs, List<List<Integer>> res) {
        if (curSum >= target) {
            if (curSum == target) {
                List<Integer> list = new ArrayList<Integer>(subs);
                Collections.sort(list);
                if (!res.contains(list))
                    res.add(list);
            }
            return;
        }

        for (int candidate : candidates) {
            subs.add(candidate);
            backTrack(candidates, curSum + candidate, target, subs, res);
            subs.remove(subs.size() - 1);
        }
    }
}
