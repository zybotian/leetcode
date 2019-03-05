package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tianbo
 * @date 2019-03-05
 */
public class FindBottomLeftValue {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(30);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(18);
        TreeNode node7 = new TreeNode(28);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node6.right = node7;
        System.out.println(solution.findBottomLeftValue(node1));
    }

    // 99.95%, 层次遍历, 返回最下面一层的第一个元素
    static class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int result = root.val;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int count = 0;
                while (size != 0) {
                    TreeNode remove = queue.remove();
                    count++;
                    if (count == 1) {
                        result = remove.val;
                    }
                    if (remove.left != null) {
                        queue.add(remove.left);
                    }
                    if (remove.right != null) {
                        queue.add(remove.right);
                    }
                    size--;
                }
            }

            return result;
        }
    }
}
