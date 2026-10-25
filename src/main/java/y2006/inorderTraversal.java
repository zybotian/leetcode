package y2006;

import common.TreeNode;
import util.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    public static void main(String[] args) {
        inorderTraversal inorderTraversal = new inorderTraversal();
        TreeNode treeNode = TreeUtils.create(new int[]{1, 2, 3}, new int[]{1, 3, 2});

        System.out.println(inorderTraversal.inorderTraversal(treeNode));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
