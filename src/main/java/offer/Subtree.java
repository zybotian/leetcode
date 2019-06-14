package offer;

import common.TreeNode;

/**
 * @author tianbo
 * @date 2019-06-14
 */
public class Subtree {

    // 二叉树的先序遍历
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            // roo1和roo2的根节点的值相同
            if (root1.val == root2.val) {
                // 看是否有合适的子树
                result = isTree1ContainsTree2(root1, root2);
            }

            // 根相同,但是没有匹配成功, 再去看root1的左子树是否有root2
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }

            // roo1的左子树中没有root2,再去看roo1的右子树中是否有root2
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    private static boolean isTree1ContainsTree2(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        return isTree1ContainsTree2(tree1.left, tree2.left) && isTree1ContainsTree2(tree1.right, tree2.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = createTree1();
        TreeNode tree2 = createTree2();
        System.out.println(hasSubtree(tree1, tree2));
    }

    private static TreeNode createTree2() {
        TreeNode root = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);

        root.left = node9;
        root.right = node2;
        return root;
    }

    private static TreeNode createTree1() {
        TreeNode root = new TreeNode(8);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node71 = new TreeNode(7);

        root.left = node8;
        root.right = node7;
        node8.left = node9;
        node8.right = node2;
        node2.left = node4;
        node2.right = node71;

        return root;
    }
}
