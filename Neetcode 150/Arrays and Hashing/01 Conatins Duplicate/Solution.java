// intution : use hashset to store the elements and check if the element is already present in the set or not if it is present return true else add the element to the set and continue the loop

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }
        return false;
    }
    public static void main(String[] args){
        int nums[] = {1,2,3,1};
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(nums));

    }
}