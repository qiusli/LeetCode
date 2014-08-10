package breadthfirstsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liqiushi on 8/9/14.
 */
public class WordLadderII {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        List<List<String>> result = findLadders("hit", "cog", dict);
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (dict == null)
            return null;

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sub = new ArrayList<String>();
        sub.add(start);
        List<String> visited = new ArrayList<String>();

        dfs(start, end, dict, res, sub, visited);

        return res;
    }

    private static void dfs(String start, String end, Set<String> dict, List<List<String>> res,
                            List<String> sub, List<String> visited) {
        for (int i = 0; i < start.length(); i++) {
            char[] curArray = sub.get(sub.size() - 1).toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                curArray[i] = c;
                String newStr = new String(curArray);

                if (newStr.equals(end)) {
                    sub.add(newStr);
                    List<String> tmp = new ArrayList<String>(sub);
                    res.add(tmp);
                    sub.remove(newStr);
                } else if (!visited.contains(newStr)) {
                    visited.add(newStr);
                    if (dict.contains(newStr)) {
                        sub.add(newStr);
                        dfs(start, end, dict, res, sub, visited);
                        sub.remove(newStr);
                    }
                }
            }
        }
    }
}
