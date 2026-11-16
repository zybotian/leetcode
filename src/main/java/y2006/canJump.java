package y2006;

public class canJump {
    public static void main(String[] args) {
        canJump canJump = new canJump();
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump.canJump(new int[]{0, 2, 3}));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {// 当前位置不可达
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
