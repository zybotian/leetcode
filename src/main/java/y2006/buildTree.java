package y2006;

import com.sun.source.tree.Tree;
import common.TreeNode;
import util.TreeUtils;

public class buildTree {
    public static void main(String[] args) {
        buildTree buildTree = new buildTree();
        TreeNode treeNode = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeUtils.visitPreOrder(treeNode);
        TreeUtils.visitInOrder(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }
        // preorder第一个元素是根节点
        TreeNode root = new TreeNode(preorder[start1]);
        // 找到根节点在inorder中的位置
        int rootIndex = 0;
        for (int i = start2; i <= end2; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        int leftSize = rootIndex - start2;
        root.left = buildTree(preorder, start1 + 1, start1 + leftSize, inorder, start2, rootIndex - 1);
        root.right = buildTree(preorder, start1 + leftSize + 1, end1, inorder, rootIndex + 1, end2);
        return root;
    }
}
