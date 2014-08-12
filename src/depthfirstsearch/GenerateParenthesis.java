package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/12/14.
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for (String s : res)
            System.out.print(s + " ");
    }

    private static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0)
            return res;

        dfs(n, 0, 0, "", res);
        return res;
    }

    private static void dfs(int n, int lefters, int righters, String sub, List<String> res) {
        if (lefters < righters)
            return;

        if (lefters == n && righters == n) {
            res.add(sub);
            return;
        }

        if (lefters == n) {
            dfs(n, lefters, righters + 1, sub + ")", res);
            return;
        }

        dfs(n, lefters + 1, righters, sub + "(", res);
        dfs(n, lefters, righters + 1, sub + ")", res);
    }
}
