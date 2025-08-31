public class twoSum{
    public static void twoSum(int[] nums, int target) {
        int n = nums.length;
        int lp = 0;
        int rp = n - 1;
        while(lp != rp){
            if(nums[lp] + nums[rp] == target){      //step 1:- target value same to (lp+rp)
                System.out.println(lp+" "+rp);
            }
            if(nums[lp] + nums[rp] > target){
                if(nums[lp] < nums[rp]){
                    lp++;
                } else{
                    rp--;
                }
                break;
            }
            if (nums[lp] + nums[rp] > target) {     //
                if(nums[lp] < nums[rp]){
                    lp++;
                } else{
                    rp--;
                }
                break;
            }
        }
        System.out.println(lp+" "+rp);
    }

    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(arr, target));
    }
}