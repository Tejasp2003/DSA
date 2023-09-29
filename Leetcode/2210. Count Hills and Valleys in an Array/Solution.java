// intution: Here we have to find the number of hills and valleys in the array, so we will iterate from the 1st index to the last index-1, and we will check if the current element is less than the previous element and also less than the next element, or if the current element is greater than the previous element and also greater than the next element, then we will increment the count, and we will return the count. we will also keep track of prev variable, which will store the previous element, and we will update the prev variable if the current element is not equal to the next element.

class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length-1; i++){
            if((nums[i] < nums[i+1] && nums[i] < prev || (nums[i] > nums[i+1] && nums[i] > prev)))
                ans++;
            if(nums[i] != nums[i+1]){
                prev = nums[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5,4,3,2,1,2,3,4,5,6,7,8};
        System.out.println(s.countHillValley(nums));
    }

}