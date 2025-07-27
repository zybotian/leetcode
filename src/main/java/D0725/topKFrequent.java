package D0725;

import java.util.*;

class topKFrequent {
    public static void main(String[] args) {
        topKFrequent topKFrequent = new topKFrequent();
        int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5};
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums, 1)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums, 2)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums, 3)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums, 4)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums, 5)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numCountMap.containsKey(nums[i])) {
                numCountMap.put(nums[i], numCountMap.get(nums[i]) + 1);
            } else {
                numCountMap.put(nums[i], 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numCountMap.get(o1) - numCountMap.get(o2);
            }
        });

        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(entry.getKey());
            } else {
                int queueFre = numCountMap.get(priorityQueue.peek());
                if (entry.getValue() > queueFre) {
                    priorityQueue.poll();
                    priorityQueue.add(entry.getKey());
                }
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            Integer poll = priorityQueue.poll();
            result[i++] = poll;
        }

        return result;
    }
}