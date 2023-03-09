import java.util.*;
//Problem link: https://leetcode.com/problems/longest-increasing-subsequence

//solution 1: Recursion
//Time complexity: O(2^n)
//Space complexity: O(n)

// class Solution {

//     private int solve(int index, int prev, int []nums){
//         if(index==nums.length) return 0;
//         int notPick = solve(index+1, prev, nums);
//         int pick =0;
//         if(prev==-1||nums[index]>nums[prev]){
//             pick = 1+ solve(index+1, index, nums);
//         }
//         return Math.max(pick ,notPick);
//     }
//     public int lengthOfLIS(int[] nums) {

//         return solve(0, -1, nums);

//     }

//     public static void main(String[] args) {
//         int[]nums= {10,9,2,5,3,7,101,18};
//         Solution s = new Solution();

//         System.out.println( s.lengthOfLIS(nums));

//     }
// }

//solution 2: Memoization
//Time complexity: O(n^2)
//Space complexity: O(n^2)

// class Solution {

//     private int solve(int index, int prev, int[] nums, int[][] dp) {
//         if (index == nums.length)
//             return 0;

//         if (dp[index][prev + 1] != -1)
//             return dp[index][prev + 1];
//         int notPick = solve(index + 1, prev, nums, dp);
//         int pick = 0;
//         if (prev == -1 || nums[index] > nums[prev]) {
//             pick = 1 + solve(index + 1, index, nums, dp);
//         }
//         return dp[index][prev + 1] = Math.max(pick, notPick);
//     }

//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int dp[][] = new int[n][n + 1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         return solve(0, -1, nums, dp);

//     }

//     public static void main(String[] args) {
//         int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
//         Solution s = new Solution();

//         System.out.println(s.lengthOfLIS(nums));

//     }

// }

//solution 3: Tabulation
//Time complexity: O(n^2)
//Space complexity: O(n^2)

// class Solution {


//     public int lengthOfLIS(int[] nums) {       
//         int n = nums.length;
//         int dp[][] = new int[n+1][n+1];
//         for(int index = n-1; index>=0; index--){
//             for(int prev = n-1; prev>=-1; prev--){
//                 int notPick = dp[index+1][prev+1];
//                 int pick =0;
//                 if(prev==-1||nums[index]>nums[prev]){
//                     pick = 1+ dp[index+1][index+1];
//                 }
//          dp[index][prev+1]= Math.max(pick ,notPick);

//             }
//         }

//         return dp[0][0];
        
//     }
// public static void main(String[] args) {
//     int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
//     Solution s = new Solution();

//     System.out.println(s.lengthOfLIS(nums));
// }
// }

//solution 4: Tabulation
//Time complexity: O(n^2)
//Space complexity: O(n)

class Solution {


    public int lengthOfLIS(int[] nums) {       
        int n = nums.length;
        int next[] = new int[n+1];
        for(int index = n-1; index>=0; index--){
            int curr[] = new int[n+1];
            for(int prev = n-1; prev>=-1; prev--){
                int notPick = next[prev+1];
                int pick =0;
                if(prev==-1||nums[index]>nums[prev]){
                    pick = 1+ next[index+1];
                }
         curr[prev+1]= Math.max(pick ,notPick);

            }
            next = curr;
        }

        return next[0];
        
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(nums));
    }
}