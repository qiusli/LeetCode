package brutalforce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/7/14.
 */
public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> result = combine(10, 7);
        for (List list : result) {
            for (int i = 0; i < list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }

    private static List<List<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<Integer> col = new ArrayList<Integer>();
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        getlist(n, k, col, re, 0);
        return re;
    }

    private static void getlist(int n, int k, List<Integer> sub, List<List<Integer>> re, int start) {
        if (sub.size() == k) {
            List<Integer> t = new ArrayList<Integer>(sub);
            re.add(t);
            return;
        }

        for (int i = start; i < n; i++) {
            sub.add(i + 1);
            getlist(n, k, sub, re, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
