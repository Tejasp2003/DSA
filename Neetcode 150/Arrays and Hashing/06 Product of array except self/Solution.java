// intution: heer we will calculate the product of left side of each element and store it in result array and then we will calculate the product of right side of each element and multiply it with the left side product of each element i.e current result value and store it in result array. The reason that we are calculating the product of left side of each element and then product of right side of each element is that we can calculate the product of right side of each element in one go and then multiply it with the left side product of each element i.e current result value and store it in result array. 
import java.util.*;
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[]=new int[n];
    //  calculate the product of left side of each element
    int left=1;
    for(int i=0; i<n; i++){
        if(i>0){
            left*=nums[i-1];
        }
        result[i]=left;
    }
    // calculate the product of right side of each element andmultiply wth left side i.e current result value
    int right=1;
    for(int i=n-1; i>=0; i--){
        if(i<n-1){
            right=right*nums[i+1];
        }
        result[i] *= right;
    }

    return result;
    
    }
    public static void main(String []args){
        Solution sol = new Solution();
        int []nums = {1,2,3,4};
        int []result = sol.productExceptSelf(nums);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}