import java.util.*;
//problem link:
//https://leetcode.com/problems/longest-common-subsequence

//solution 1: Recursion
//Time complexity: O(2^n)
//Space complexity: O(n)

// class Solution {
//     private int solve(int i, int j, String text1, String text2)
//     {
//     //base case
//         if(i==text1.length() || j ==text2.length()) return 0;
//         if(text1.charAt(i)==text2.charAt(j)){
//             return 1+solve(i+1, j+1, text1, text2);
//         }
//         else{
//             return  Math.max(solve(i+1, j, text1, text2), solve(i, j+1, text1, text2));
//         }
       

//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         return solve(0,0, text1, text2);
        
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         System.out.println(s.longestCommonSubsequence("abcde", "ace"));
//     }
// }


//solution 2: Memoization
//Time complexity: O(n^2)
//Space complexity: O(n^2)

// class Solution {
//     private int solve(int i, int j, String text1, String text2, int[][] dp)
//     {
//     //base case
//         if(i==text1.length() || j ==text2.length()) return 0;
//         if(dp[i][j]!=-1)return dp[i][j];
//         if(text1.charAt(i)==text2.charAt(j)){
//             return dp[i][j]= 1+solve(i+1, j+1, text1, text2, dp);
//         }
//         else{
//             return  dp[i][j]= Math.max(solve(i+1, j, text1, text2, dp), solve(i, j+1, text1, text2, dp));
//         }
       

//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         int[][] dp = new int[m][n];
//         for(int[] row: dp){
//             Arrays.fill(row, -1);
//         }

//         return solve(0,0, text1, text2, dp);
        
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         System.out.println(s.longestCommonSubsequence("abcde", "ace"));
//     }
// }

//solution 3: Tabulation
//Time complexity: O(n^2)
//Space complexity: O(n^2)


// class Solution {
   
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         int[][] dp = new int[m+1][n+1];
   

//         for(int i=m-1;i>=0; i--){
//             for(int j =n-1; j>=0; j--){
//                 if(text1.charAt(i)==text2.charAt(j)){
//                      dp[i][j]= 1+dp[i+1][j+1];
//                 }
//                 else{
//                       dp[i][j]= Math.max(dp[i+1][j], dp[i][j+1]);
//                 }
//             }
//         }

//         return dp[0][0];
        
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         System.out.println(s.longestCommonSubsequence("abcde", "ace"));
//     }
// }

//solution 4: Tabulation (Space Optimized)
//Time complexity: O(n^2)
//Space complexity: O(n)

class Solution {
   
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[]next = new int[n+1];
   

        for(int i=m-1;i>=0; i--){
            int[]curr = new int[n+1];
            for(int j =n-1; j>=0; j--){
                if(text1.charAt(i)==text2.charAt(j)){
                     curr[j]= 1+next[j+1];
                }
                else{
                      curr[j]= Math.max(next[j], curr[j+1]);
                }
            }
            next= curr;
        }

        return next[0];
        
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonSubsequence("abcde", "ace"));
    }
}