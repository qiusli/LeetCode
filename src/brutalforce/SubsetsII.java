package brutalforce;

import java.util.*;

/**
 * Created by liqiushi on 8/5/14.
 */
public class SubsetsII {
    public static void main(String[] args) {
        int[] S = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(S);
        for (List list : result) {
            for (int i = 0; i < list.size(); i++)
                System.out.print(list.get(i) + " ");

            System.out.println();
        }
    }

    private static List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null)
            return result;

        Arrays.sort(num);
        Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        combine(num, result, map, num.length - 1);
        return result;
    }

    private static void combine(int[] S, List<List<Integer>> result, Map<List<Integer>, Integer> map, int index) {
        if (index == -1) {
            List<Integer> list = new ArrayList<Integer>();
            result.add(list);
            return;
        }

        combine(S, result, map, index - 1);

        // 对result中的每一个list，加上当前S[index]这个元素
        int size = result.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<Integer>(result.get(i));
            list.add(S[index]);

            if (map.get(list) == null) {
                result.add(list);
                map.put(list, 1);
            }
        }
    }
}
