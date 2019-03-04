package tree;

import common.TreeNode;

/**
 * @author tianbo
 * @date 2019-03-04
 */
public class Tree2str {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        Solution solution = new Solution();
        System.out.println(solution.tree2str(node1));
    }

    // 击败79.86%
    static class Solution {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(t.val);
            if (t.left != null) {
                sb.append("(");
                sb.append(tree2str(t.left));
                sb.append(")");
            }
            if (t.right != null) {
                if (t.left == null) {
                    sb.append("()");
                }
                sb.append("(");
                sb.append(tree2str(t.right));
                sb.append(")");
            }
            return sb.toString();
        }
    }
}
