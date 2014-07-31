package tree;

import tree.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiushi on 7/25/14.
 */
public class ConstructBinaryFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 8, 9, 5, 3, 6, 10, 11, 7};
        int[] inorder = {8, 4, 9, 2, 5, 1, 10, 6, 11, 3, 7};
        TreeNode result = buildTree(preorder, inorder);
        System.out.print("");
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;

        // store inorder val_index pairs
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, 0, inorder.length - 1, map);
    }

    private static TreeNode build(int[] preorder, int pre_start,
                                  int in_start, int in_end, Map<Integer, Integer> map) {
        if (in_start > in_end)
            return null;

        if (pre_start > preorder.length - 1)
            return null;

        int start = pre_start + 1;
        int mid_index = map.get(preorder[pre_start]);
        TreeNode root = new TreeNode(preorder[pre_start]);
        root.left = build(preorder, start, in_start, mid_index - 1, map);
        root.right = build(preorder, start, mid_index + 1, in_end, map);

        return root;
    }
}
