// intution: Here we have to find the 132 patter i.e. we have to find the triplet i,j,k such that i<j<k and nums[i]<nums[k]<nums[j], so we will iterate from the last index to the 1st index, and we will check if the current element is less than the kth element, then we will return true, else we will check if the stack is not empty and the top element of the stack is less than the current element, then we will pop the top element of the stack and update the kth element, and we will push the current element into the stack. At the end we will return false.

import java.util.Stack;
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st= new Stack();
        int kthElement = Integer.MIN_VALUE;
        for(int i= nums.length-1; i>=0; i--){
            if(nums[i]<kthElement){
                return true;
            }
            while(!st.isEmpty() && st.peek()<nums[i]){
                kthElement=st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(s.find132pattern(nums));
    }
    
}