package graph;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-03-14
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pre1 = {{1, 0}};
        int[][] pre2 = {{1, 0}, {0, 1}};

        int[][] pre3 = {{1, 0}, {0, 2}};

        int[][] pre4 = {{1, 2}, {2, 3}, {3, 0}};

        int[][] pre5 = {{1, 0}, {2, 0}};

        int[][] pre6 = {{0, 1}, {0, 2}, {1, 2}};

        int[][] pre7 = {{1, 0}, {0, 2}, {2, 1}};

        int[][] pre8 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}, {4, 3}, {5, 3}, {5, 4}};

        System.out.println(Arrays.toString(solution.findOrder(2, pre1)));
        System.out.println(Arrays.toString(solution.findOrder(2, pre2)));
        System.out.println(Arrays.toString(solution.findOrder(3, pre3)));
        System.out.println(Arrays.toString(solution.findOrder(4, pre4)));
        System.out.println(Arrays.toString(solution.findOrder(3, pre5)));
        System.out.println(Arrays.toString(solution.findOrder(3, pre6)));
        System.out.println(Arrays.toString(solution.findOrder(3, pre7)));
        System.out.println(Arrays.toString(solution.findOrder(6, pre8)));
    }

    // 72.38%, topology sort.sort, BFS
    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // 入度数组
            int[] inDegrees = new int[numCourses];
            // key是顶点, value是从顶点key出发直接可达的顶点(间接可达不算)
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int[] edge : prerequisites) {
                // edge[0]依赖于edge[1], 即edge[1]指向edge[0]
                int start = edge[1];
                int end = edge[0];
                // edge[0]的入度加1
                inDegrees[end]++;
                if (!graph.containsKey(start)) {
                    graph.put(start, new ArrayList<Integer>());
                }
                // start顶点直接到达的顶点列表中假如end
                graph.get(start).add(end);
            }

            /**
             * topology sort.sort 拓扑排序:
             * 在有向图中选一个没有前驱的顶点并且输出
             * 从图中删除该顶点和所有以它为尾的弧, 即删除所有与它有关的边
             * 重复上述两步, 直至全部顶点均已输出; 或者当图中不存在无前驱的顶点为止
             */

            // 将入度为0的顶点放入队列中
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegrees.length; i++) {
                if (inDegrees[i] == 0) {
                    queue.add(i);
                }
            }

            int count = 0;
            int[] result = new int[numCourses];
            while (!queue.isEmpty()) {
                // 队头出队列
                Integer top = queue.poll();
                result[count++] = top;

                List<Integer> neighbors = graph.get(top);

                // 有邻居的话, 所有邻居的入度减1
                if (neighbors != null) {
                    for (Integer neighbor : neighbors) {
                        inDegrees[neighbor]--;
                        // 如果入度为0, 假如到队列中
                        if (inDegrees[neighbor] == 0) {
                            queue.add(neighbor);
                        }
                    }
                }
            }

            return count == numCourses ? result : new int[0];
        }
    }
}
