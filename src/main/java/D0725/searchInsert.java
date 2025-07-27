package D0725;

class searchInsert {

    public static void main(String[] args) {
        searchInsert searchInsert = new searchInsert();
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert.searchInsert(nums, 5));
        System.out.println(searchInsert.searchInsert(nums, 2));
        System.out.println(searchInsert.searchInsert(nums, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}