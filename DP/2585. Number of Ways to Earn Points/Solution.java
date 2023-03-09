
import java.util.*;
//Problem Link:
//https://leetcode.com/problems/number-of-ways-to-earn-points/

//Approach 1: Recursion

//Time Complexity: O(2^n)
//Space Complexity: O(n)

// class Solution {
//     static int mod = 1000000007;
//     static int solve(int index, int target, int[][] types){
//         //if we reached the target, then return 1
//         if(index==types.length){
    // if(target==0) return 1;
    // else return 0;
// }
//         //we pick a question
//         int take =0;
        
        
//         for(int i =1; i<=types[index][0]; i++){
//             int sum = target - (i * types[index][1]);
//             if(sum>=0){
//                 take += solve(index+1, sum, types );
//             }
//             take %= mod;
//         }
//         int notTake = solve(index+1, target, types);
//         return (take + notTake)%mod;


//     }
//     public int waysToReachTarget(int target, int[][] types) {
//         int n = types.length;

//      return solve(0, target, types);
//    }

//    public static void main(String[] args) {
//     Solution s= new Solution();
//     int target = 6;
//     int types[][] = {{6,1},{3,2},{2,3}};
//     System.out.println(s.waysToReachTarget(target, types));
//    }
// }

//Approach 2: Recursion + Memoization
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

// class Solution {
//     static int mod = 1000000007;
//     static int solve(int index, int target, int[][] types, int[][] dp){
//         //if we reached the target, then return 1
//         if(index==types.length){
//             if(target==0) return 1;
//             else return 0;
//         }
//         //we pick a question
//         int take =0;
//         if(dp[index][target]!=-1)return dp[index][target];
        
//         for(int i =1; i<=types[index][0]; i++){
//             int sum = target - (i * types[index][1]);
//             if(sum>=0){
//                 take += solve(index+1, sum, types, dp );
//             }
//             take %= mod;
//         }
//         int notTake = solve(index+1, target, types, dp);
//         return dp[index][target]=(take + notTake)%mod;


//     }
//     public int waysToReachTarget(int target, int[][] types) {
//         int n = types.length;
//         int dp[][] = new int[n][target+1];
//         for(int [] row: dp){
//             Arrays.fill(row, -1);
//         }
//      return solve(0, target, types, dp);
//    }

//     public static void main(String[] args) {
//      Solution s= new Solution();
//      int target = 6;
//      int types[][] = {{6,1},{3,2},{2,3}};
//      System.out.println(s.waysToReachTarget(target, types));
//     }
// }

//Approach 3: Iterative + Memoization
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

class Solution {
    static int mod = 1000000007;
    
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int dp[][] = new int[n+1][target+1];
       
        for(int i =0; i<=n ;i++) dp[i][0]=1;
        for(int index=n-1; index>=0; index--){
            for(int tar =1; tar<=target; tar++){
                int take =0;
                for(int i =1; i<=types[index][0]; i++){
                    int sum = tar - (i * types[index][1]);
                    if(sum>=0){
                        take += dp[index+1][sum];
                    }
                    take %= mod;
                    }
                    int notTake = dp[index+1][tar];
                    dp[index][tar]=(take + notTake)%mod;
                }
        }
     return dp[0][target];
   }

    public static void main(String[] args) {
     Solution s= new Solution();
     int target = 6;
     int types[][] = {{6,1},{3,2},{2,3}};
     System.out.println(s.waysToReachTarget(target, types));
    }
}