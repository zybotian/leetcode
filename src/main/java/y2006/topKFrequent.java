package y2006;

import java.util.*;

public class topKFrequent {
    public static void main(String[] args) {
        topKFrequent topKFrequent = new topKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 1)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 3)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numCountMap.put(nums[i], numCountMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numCountMap.get(o1).compareTo(numCountMap.get(o2));
            }
        });

        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry.getKey());
            } else {
                if (numCountMap.get(queue.peek()) < entry.getValue()) {
                    queue.poll();
                    queue.add(entry.getKey());
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
