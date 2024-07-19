package backtrack;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        combinationSum(candidates, target, result, tmpResult, 0);
        return result;
    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpResult, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(tmpResult));
            return;
        }
        if (index >= candidates.length) {
            return;
        }

        combinationSum(candidates, target, result, tmpResult, index + 1);

        if (target - candidates[index] >= 0) {
            tmpResult.add(candidates[index]);
            combinationSum(candidates, target - candidates[index], result, tmpResult, index);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }
}