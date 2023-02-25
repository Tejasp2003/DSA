class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
    int start =0;
    int end = nums.length-1;
    
    int mid =0;
    if(nums.length == 1) return nums[0];
    while(start<end){

        mid = start +(end-start)/2;
        if((mid%2==0  && nums[mid]==nums[mid+1] )|| (mid%2==1 &&nums[mid]==nums[mid-1])) {
            start = mid+1;
        }
        else{
            end = mid;
        }
        
    }
    return nums[start];
    
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(s.singleNonDuplicate(nums));
    }
}