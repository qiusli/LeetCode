package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/9/14.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> res = partition("amanaplanacanalpanama");
//        for (List<String> list : res) {
//            for (String s : list)
//                System.out.print(s + " ");
//            System.out.println();
//        }
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null)
            return res;

        List<String> sub = new ArrayList<String>();
        dfs(s, sub, res, 0);

        return res;
    }

    private static void dfs(String s, List<String> sub, List<List<String>> res, int index) {
        if (index == s.length()) {
            List<String> tmp = new ArrayList<String>(sub);
            res.add(tmp);
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String str = s.substring(index, i);
            if (isPalindrome(str)) {
                sub.add(str);
                dfs(s, sub, res, index + 1);
                sub.remove(sub.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int front = s.length() - 1, rear = 0;
        while (front >= rear) {
            if (s.charAt(front) != s.charAt(rear))
                return false;
            front--;
            rear++;
        }
        return true;
    }
}
