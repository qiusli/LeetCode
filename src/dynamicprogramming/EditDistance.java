//package dynamicprogramming;
//
///**
// * Created by liqiushi on 8/26/14.
// */
//public class EditDistance {
//    public static void main(String[] args) {
//        System.out.println(minDistance("mym", "abc"));
//    }
//
//    private static int minDistance(String word1, String word2) {
//        if (word1.length() == 0)
//            return word2.length();
//
//        if (word2.length() == 0)
//            return word1.length();
//
//        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//        for (int i = 0; i < word1.length(); i++) {
//            dp[i][0] = i;
//        }
//
//        for (int i = 0; i < word2.length(); i++) {
//            dp[0][i] = i;
//        }
//
//        for (int i = 1; i < word1.length(); i++) {
//            for (int j = 1; j < word2.length(); j++) {
//                if (word1.charAt(i) == word2.charAt(j)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//
//                }
//            }
//        }
//    }
//}
