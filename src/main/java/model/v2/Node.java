package model.v2;

/**
 * @author tianbo
 * @date 2019-03-01
 */
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
