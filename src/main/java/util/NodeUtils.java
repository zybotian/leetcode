package util;


import model.v2.Node;

public class NodeUtils {

    public static void println(Node node) {
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }
}
