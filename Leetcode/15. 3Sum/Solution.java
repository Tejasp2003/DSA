// intution: The method first sorts the input array in ascending order using the Arrays.sort method. It then iterates through the array using a for loop. For each element nums[i], it uses two pointers j and k to find all pairs of elements nums[j] and nums[k] that sum up to -nums[i].

//The method uses two while loops to move the pointers j and k towards each other until they meet or the sum of the three elements is greater than zero. If the sum is zero, the method adds the triplet to the result list and moves the pointers j and k to the next unique elements. If the sum is greater than zero, the method decrements k to reduce the sum. If the sum is less than zero, the method increments j to increase the sum.

//The method also includes two if statements to skip over duplicate elements in the input array and the result list.


import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                    
                }
                else if(sum>0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        Solution obj = new Solution();
        List<List<Integer>> ans = obj.threeSum(nums);
        System.out.println(ans);
    }
}