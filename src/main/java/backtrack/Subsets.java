package backtrack;

import java.util.ArrayList;
import java.util.List;

class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        subsets(nums, result, tmpResult, 0);
        return result;
    }

    private void subsets(int[] nums, List<List<Integer>> result, List<Integer> tmpResult, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(tmpResult));
            return;
        }

        // 选择当前元素
        subsets(nums, result, tmpResult, index + 1);

        // 不选择当前元素
        tmpResult.add(nums[index]);
        subsets(nums, result, tmpResult, index + 1);
        tmpResult.remove(tmpResult.size() - 1);
    }
}