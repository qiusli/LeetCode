package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiushi on 7/6/14.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] A = {3, 3, 1, 1, 2, 2, 4, 4, 5, 6, 6, 7, 7, 8, 8};
        System.out.print(singleNumber(A));
    }

    private static int singleNumber(int[] A) {
        if (A == null)
            return Integer.MAX_VALUE;

        int unique = Integer.MAX_VALUE;

        Map<Integer, Integer> val_freq = new HashMap<Integer, Integer>();
        for (int a : A) {
            if (!val_freq.containsKey(a))
                val_freq.put(a, 1);
            else
                val_freq.put(a, val_freq.get(a) + 1);
        }

        for (int a : A) {
            if (val_freq.get(a) == 1)
                return a;
        }

        return unique;
    }
}
