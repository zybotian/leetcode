package offer;

import common.TreeNode;
import util.TreeDisplay;

/**
 * @author tianbo
 * @date 2019-06-14
 */
public class BinTreeReCreate {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode result = recreate(pre, in);
        TreeDisplay.visitInOrder(result);
    }

    public static TreeNode recreate(int[] preOrder, int[] inOrder) {
        return recreate(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private static TreeNode recreate(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 先序遍历的第一个节点是根节点
        TreeNode root = new TreeNode(preOrder[preStart]);
        int indexOfRoot = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (preOrder[preStart] == inOrder[i]) {
                indexOfRoot = i;
                break;
            }
        }
        root.left = recreate(preOrder, preStart + 1, preStart + indexOfRoot - inStart, inOrder, inStart, indexOfRoot - 1);
        root.right = recreate(preOrder, preStart + indexOfRoot - inStart + 1, preEnd, inOrder, indexOfRoot + 1, inEnd);
        return root;
    }


}
