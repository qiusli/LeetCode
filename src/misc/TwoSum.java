package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiushi on 8/28/14.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {11, 7, 15, 2};
        int[] res = twoSum(numbers, 9);
        for (int i : res)
            System.out.print(i + " ");

        int[] numbers2 = {3, 2, 4};
        int[] res2 = twoSum(numbers2, 6);
        for (int i : res2)
            System.out.print(i + " ");

        int[] numbers3 = {0, 4, 3, 0};
        int[] res3 = twoSum(numbers3, 0);
        for (int i : res3)
            System.out.print(i + " ");
    }

    private static int[] twoSum(int[] numbers, int target) {
        if (numbers == null)
            return null;

        int[] res = new int[2];

        // value : index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            } else {
                map.put(numbers[i], i);
            }
        }

        return res;
    }
}
