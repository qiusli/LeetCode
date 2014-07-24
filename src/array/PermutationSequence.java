package array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liqiushi on 6/29/14.
 */
public class PermutationSequence {
    public static void main(String[] args) {
        System.out.print(getPermutation(4, 17));
    }

    private static String getPermutation(int n, int k) {
        if (n == 0)
            return null;

        if (k < 1)
            return null;

        if (k > getFactorial(n))
            return null;

        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            list.add(i);

        String result = "";
        while (n > 0) {
            int rightFactorial = getFactorial(n - 1);
            // 始终指向上一个
            int headIndex = k % rightFactorial == 0 ? k / rightFactorial - 1 : k / rightFactorial;

            result += list.get(headIndex);

            k -= headIndex * getFactorial(n - 1);

            list.remove(list.indexOf(list.get(headIndex)));
            n--;
        }

        return result;
    }

    private static int getFactorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }

        return result;
    }
}
