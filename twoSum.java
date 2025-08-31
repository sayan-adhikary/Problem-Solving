public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int lp = 0;
        int rp = n - 1;

        while (lp < rp) {
            int sum = nums[lp] + nums[rp];

            if (sum == target) {   // Found the pair
                return new int[]{lp, rp};
            } 
            else if (sum < target) {
                lp++;   // increase sum
            } 
            else {
                rp--;   // decrease sum
            }
        }
        return new int[]{-1, -1};  // not found
    }

    public static void main(String[] args) {
        int arr[] = {3,2,4};
        int target = 6;
        int[] ans = twoSum(arr, target);
        System.out.println(ans[0] + " " + ans[1]); // Output: 0 1
    }
}
