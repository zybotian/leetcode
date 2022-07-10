package offer;

import model.Node;

import java.util.ArrayList;
import java.util.List;

public class Tree2DoubleList {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        List<Node> nodeList = new ArrayList<>();
        inOrder(root, nodeList);

        if (nodeList == null && nodeList.size() == 0) {
            return null;
        }

        if (nodeList.size() == 1) {
            root.right = root;
            root.left = root;
            return root;
        }

        Node head = nodeList.get(0);
        Node pre = null, next = null;
        for (int i = 0, size = nodeList.size(); i < size - 1; i++) {
            pre = nodeList.get(i);
            next = nodeList.get(i + 1);
            pre.right = next;
            next.left = pre;
        }
        next.right = head;
        head.left = next;

        return head;
    }

    private void inOrder(Node root, List<Node> queue) {
        if (root != null) {
            inOrder(root.left, queue);
            queue.add(root);
            inOrder(root.right, queue);
        }
    }
}
