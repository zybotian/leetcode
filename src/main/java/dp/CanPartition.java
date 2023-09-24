package dp;

import java.util.Arrays;

public class CanPartition {

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{1, 5, 5, 11}));
        System.out.println(canPartition.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(canPartition.canPartition(new int[]{1, 1, 2, 2}));

    }

    public boolean canPartition(int[] nums) {
        return false;
    }
}
