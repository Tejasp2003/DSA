
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for(int i=0, j=0; j<nums.length; j++){
            if(nums[j]%2==0){
                int temp = nums[i];
                nums[i]= nums[j];
                nums[j]=temp;
                i++;
            }
        }
        return nums;
        
    }
    public static void main(String []args){
        Solution sol = new Solution();
        int []nums = {3,1,2,4};
        int []result = sol.sortArrayByParity(nums);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}