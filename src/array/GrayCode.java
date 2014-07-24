package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 7/4/14.
 */
public class GrayCode {
    public static void main(String[] args) {
        List<Integer> num = grayCode(3);
        for (int n : num)
            System.out.println(n);
    }

    private static List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            return list;
        }

        List<Integer> result = grayCode(n - 1);

        for (int i = result.size() - 1; i >= 0; i--) {
            result.add(result.get(i) + (1 << (n - 1)));
        }

        return result;
    }
}
