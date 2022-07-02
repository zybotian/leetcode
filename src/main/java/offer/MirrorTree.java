package offer;

import common.TreeNode;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 构建二叉树镜像
        TreeNode result = new TreeNode(root.val);
        // 左子树是右子树的镜像
        result.left = mirrorTree(root.right);
        // 右子树是左子树的镜像
        result.right = mirrorTree(root.left);
        return result;
    }
}
