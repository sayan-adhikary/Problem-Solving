import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class that provides a solution to the 3Sum problem using a two-pointer approach.
 */
public class ThreeSumSolution {

    /**
     * Finds all unique triplets in the array that sum up to zero.
     *
     * @param nums the input array of integers
     * @return a list of lists containing all unique triplets that sum to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if the array has less than 3 elements, no triplets can be formed.
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        // Sort the array to simplify the duplicate checking and use two-pointer technique.
        Arrays.sort(nums);
        
        // Loop through each element, treating it as the first element (a) of the potential triplet.
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;               // start pointer for the second element (b)
            int right = nums.length - 1;      // end pointer for the third element (c)
            
            while (left < right) {
                // Calculate the sum of current triplet candidate.
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a valid triplet.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for left pointer.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for right pointer.
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers for the next iteration.
                    left++;
                    right--;
                } else if (sum < 0) {
                    // If sum is less than zero, move the left pointer to increase the sum.
                    left++;
                } else {
                    // If sum is greater than zero, move the right pointer to reduce the sum.
                    right--;
                }
            }
        }
        
        return result;
    }

    /**
     * Main method to run a sample test.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        ThreeSumSolution solver = new ThreeSumSolution();
        
        // Sample test case.
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = solver.threeSum(nums);
        
        // Display the result.
        System.out.println("Unique triplets that sum up to zero:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}