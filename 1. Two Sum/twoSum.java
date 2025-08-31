import java.util.*;

public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // Step 1: Store value with index
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];  // value
            arr[i][1] = i;        // original index
        }

        // Step 2: Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Two pointer approach
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left][0] + arr[right][0];
            if (sum == target) {
                return new int[]{arr[left][1], arr[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{}; // should never reach here (guaranteed solution exists)
    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1, target1))); // [0,1]

        int[] nums2 = {3,2,4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // [1,2]

        int[] nums3 = {3,3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(nums3, target3))); // [0,1]
    }
}
