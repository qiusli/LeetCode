package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/22/14.
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        System.out.println(minimumTotal(triangle));
    }

    // use O(n^2) space
    private static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null)
            return 0;

        int[][] t = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++)
            for (int j = 0; j < triangle.get(i).size(); j++)
                t[i][j] = triangle.get(i).get(j);

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                t[i][j] += Math.min(t[i + 1][j], t[i + 1][j + 1]);
            }
        }

        return t[0][0];
    }
}
