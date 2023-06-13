import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = nums[i];
            
            // Check if the next number is consecutive
            while (i + 1 < n && nums[i + 1] - nums[i] == 1) {
                i++; // Move to the next element
            }

            // If a range is found, add it to the result list
            if (start != nums[i]) {
                ans.add("" + start + "->" + nums[i]);
            } else {
                // If no range is found, add the single number to the result list
                ans.add("" + start);
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,5,6,9,15,16};
        Solution s= new Solution();
        System.out.println(s.summaryRanges(nums));
    }
}
