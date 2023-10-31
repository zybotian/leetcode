package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        permute(nums, result, tmpResult);
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> tmpResult) {
        if (tmpResult.size() == nums.length) {
            result.add(new ArrayList<>(tmpResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmpResult.contains(nums[i])) {
                continue;
            }
            tmpResult.add(nums[i]);
            permute(nums, result, tmpResult);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }
}