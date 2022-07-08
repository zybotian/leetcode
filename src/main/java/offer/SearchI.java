package offer;


public class SearchI {

    public static void main(String[] args) {
        SearchI searchI = new SearchI();
        System.out.println(searchI.search(new int[]{1}, 1));
        System.out.println(searchI.search(new int[]{5, 7, 7, 8, 8, 10}, 5));
        System.out.println(searchI.search(new int[]{5, 7, 7, 8, 8, 10}, 7));
        System.out.println(searchI.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(searchI.search(new int[]{5, 7, 7, 8, 8, 10}, 10));
        System.out.println(searchI.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                int count = 0;
                for (int i = mid; i <= end; i++) {
                    if (nums[i] == target) {
                        count++;
                    } else {
                        break;
                    }
                }
                for (int i = mid - 1; i >= start; i--) {
                    if (nums[i] == target) {
                        count++;
                    } else {
                        break;
                    }
                }
                return count;
            }
        }

        return 0;
    }

    public int searchV2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                while (i < nums.length && nums[i] == target) {
                    count++;
                    i++;
                }
                break;
            }
        }

        return count;
    }

}
