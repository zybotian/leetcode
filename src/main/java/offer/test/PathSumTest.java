package offer.test;

import common.TreeNode;
import offer.PathSum;
import util.TreeUtils;

import java.util.List;

public class PathSumTest {
    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode treeNode = TreeUtils.create(new int[]{5, 4, 3, 6, 10}, new int[]{3, 4, 6, 5, 10});
        List<List<Integer>> lists = pathSum.pathSum(treeNode, 15);
        System.out.println(lists);
    }
}
