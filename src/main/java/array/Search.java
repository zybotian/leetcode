package array;

public class Search {

    public static void main(String[] args) {
        Search search = new Search();
        int[] data = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search.search(data, 4));
        System.out.println(search.search(data, 5));
        System.out.println(search.search(data, 6));
        System.out.println(search.search(data, 7));
        System.out.println(search.search(data, 0));
        System.out.println(search.search(data, 1));
        System.out.println(search.search(data, 2));

        int[] data2 = {1};
        System.out.println(search.search(data2, 0));

    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;

    }


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 2,3,4,5,6,7,0,1
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // 6,7,0,1,2,3,4,5
                // nums[low] > nums[mid]
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
