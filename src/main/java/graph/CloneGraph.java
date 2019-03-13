package graph;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-03-13
 */
public class CloneGraph {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;

        List<Node> neighbors1 = new ArrayList<>();
        neighbors1.add(node2);
        neighbors1.add(node4);
        node1.neighbors = neighbors1;

        List<Node> neighbors2 = new ArrayList<>();
        neighbors2.add(node1);
        neighbors2.add(node3);
        node2.neighbors = neighbors2;

        List<Node> neighbors3 = new ArrayList<>();
        neighbors3.add(node2);
        neighbors3.add(node4);
        node3.neighbors = neighbors3;

        List<Node> neighbors4 = new ArrayList<>();
        neighbors4.add(node1);
        neighbors4.add(node3);
        node4.neighbors = neighbors4;

        solution.cloneGraph(node1);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// DFS, 100%
class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node tmp = new Node(node.val, new ArrayList<Node>());
        map.put(node, tmp);
        for (Node neighbor : node.neighbors) {
            Node newNode = cloneGraph(neighbor);
            tmp.neighbors.add(newNode);
        }
        return map.get(node);
    }
}

//BFS. 89.98%
class Solution1 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        map.put(node, new Node(node.val, new ArrayList<Node>()));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node top = queue.poll();
            for (Node neighbor : top.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
                    queue.add(neighbor);
                }
                map.get(top).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}

