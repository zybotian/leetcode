package model;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + (left != null ? left.val : "NULL") +
                ", right=" + (right != null ? right.val : "NULL") +
                '}';
    }
}