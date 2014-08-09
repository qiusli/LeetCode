package breadthfirstsearch;

import java.util.*;

/**
 * Created by liqiushi on 8/9/14.
 */
public class WordLadder {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(ladderLength("hit", "cog", dict));

        Set<String> dict2 = new HashSet<String>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        System.out.println(ladderLength("a", "c", dict2));
    }

    private static int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || start.trim().length() == 0)
            return 0;

        if (end == null || end.trim().length() == 0)
            return 0;

        if (dict == null)
            return 0;

        List<String> list = new LinkedList<String>();
        List<Integer> depth = new LinkedList<Integer>();
        depth.add(1);
        list.add(start);

        while (!list.isEmpty()) {
            String curWord = list.remove(0);
            int curDepth = depth.remove(0);

            if (curWord.equals(end))
                return curDepth;

            for (int i = 0; i < curWord.length(); i++) {
                char[] curWordArray = curWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    curWordArray[i] = c;

                    String newWord = new String(curWordArray);
                    if (newWord.equals(end))
                        return curDepth + 1;

                    if (dict.contains(newWord)) {
                        list.add(newWord);
                        dict.remove(newWord);
                        depth.add(curDepth + 1);
                    }
                }
            }
        }

        return 0;
    }
}
