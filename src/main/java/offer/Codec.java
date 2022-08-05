package offer;

import common.TreeNode;
import util.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String rootValue = String.valueOf(root.val);
        return rootValue + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] tokenArray = data.split(",");
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokenArray));
        return deserialize(tokenList);
    }

    private TreeNode deserialize(List<String> tokens) {
        String token = tokens.get(0);

        if (token.equals("#")) {
            tokens.remove(0);
            return null;
        }

        tokens.remove(0);
        TreeNode root = new TreeNode(Integer.valueOf(token));
        root.left = deserialize(tokens);
        root.right = deserialize(tokens);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = TreeUtils.create(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5});
        TreeUtils.visitPreOrder(root);
        System.out.println();
        TreeUtils.visitInOrder(root);

        String str = codec.serialize(TreeUtils.create(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5}));
        System.out.println(str);

        TreeNode result = codec.deserialize(str);
        TreeUtils.visitPreOrder(result);
        System.out.println();
        TreeUtils.visitInOrder(result);

    }
}