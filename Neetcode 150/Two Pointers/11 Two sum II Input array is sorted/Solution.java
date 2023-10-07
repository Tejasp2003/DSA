// intution: Here we take two pointers i and j and check if the nums[i] + nums[j] is equal to target then we return the indices of i and j. If the sum is greater than target then we decrement j and if the sum is less than target then we increment i. We do this until i is less than j. If we don't find any such pair then we return {-1,-1}. As the array is laready sorted, of we find nums[i]+nums[j]>target, we reduce trhe valyue my reducing j or else we increase i.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j = nums.length-1;
         
         while(i<j){
             
             if(nums[j]==target-nums[i]){
                 return new int[]{i+1, j+1};
             }
             else if(nums[j]+nums[i]>target){
                 j--;
             }
             else{
                 i++;
             }
         }
         return new int[]{-1,-1};
        
    }
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution obj = new Solution();
        int[] ans = obj.twoSum(nums, target);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }

    }
}