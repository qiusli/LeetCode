package array;

/**
 * Created by liqiushi on 7/5/14.
 * http://blog.csdn.net/kenden23/article/details/14106137
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2};
        int[] cost = {2, 1};
        System.out.print(canCompleteCircuit(gas, cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null)
            return -1;

        if (gas.length != cost.length)
            return -1;

        for (int i = 0; i < gas.length; ) {
            int tmp = isStarter(gas, cost, i);
            if (tmp == i)
                return i;

            i = tmp;
        }

        return -1;
    }

    // return starter if succeed, otherwise next starter
    private static int isStarter(int[] gas, int[] cost, int i) {
        int amount = 0;

        int k;
        for (k = i; k < i + gas.length; k++) {
            int t = k % gas.length;
            amount += (gas[t] - cost[t]);

            if (amount < 0)
                return k + 1;
        }

        return i;
    }
}
