//package tree;
//
//import tree.node.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by liqiushi on 7/31/14.
// */
//public class UniqueBinarySearchTrees {
//    public static void main(String[] args) {
//        generateTrees(3);
//    }
//
//    private static List<TreeNode> generateTrees(int n) {
//        List<TreeNode> result = new ArrayList<TreeNode>();
//        if (n == 0)
//            return result;
//
//        for (int rt_val = 1; rt_val <= n; rt_val++) {
//            result.add(generate(rt_val, n));
//        }
//
//        return result;
//    }
//
//    private static TreeNode generate(int rt_v, int n) {
//
//    }
//}
