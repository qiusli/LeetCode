package brutalforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqiushi on 8/5/14.
 * http://blog.csdn.net/linhuanmars/article/details/24286377
 */
public class Subsets {
    public static void main(String[] args) {
        int[] S = {1, 2, 3, 4};
        List<List<Integer>> result = subsets(S);
        for (List list : result) {
            for (int i = 0; i < list.size(); i++)
                System.out.print(list.get(i) + " ");

            System.out.println();
        }
    }

    private static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null)
            return result;

        Arrays.sort(S);
        combine(S, result, S.length - 1);
        return result;
    }

    private static void combine(int[] S, List<List<Integer>> result, int index) {
        if (index == -1) {
            List<Integer> list = new ArrayList<Integer>();
            result.add(list);
            return;
        }

        combine(S, result, index - 1);

        // 对result中的每一个list，加上当前S[index]这个元素
        int size = result.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<Integer>(result.get(i));
            list.add(S[index]);
            result.add(list);
        }
    }
}
