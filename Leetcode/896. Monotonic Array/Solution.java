class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1]){
                isIncreasing=true;
            }
            if(nums[i]<nums[i-1]){
                isDecreasing = true;
            }
            if(isIncreasing && isDecreasing) return false;
        }
        return isIncreasing && isDecreasing ? false: true;
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,2,3};
        System.out.println(s.isMonotonic(nums));
    }
}