//Problem Link: 
//https://leetcode.com/problems/coin-change-2/


//Approach 1: Recursion

//Time Complexity: O(2^n)
//Space Complexity: O(n)


// class Solution {
//     static int solve(int index, int amount, int coins[]){
//         if(index==0){
//             //we have been into last index, hence we will check if the remaining target can be acheived by coins[0] or not
//             if(amount%coins[0]==0) return 1;
//             else return 0;
//         }
//         int notPick = solve(index-1, amount, coins);
//         int pick =0;
//         if(coins[index]<=amount){
//             pick =  solve(index, amount-coins[index], coins);
//         }
//         return pick + notPick;
//     }
//     public int change(int amount, int[] coins) {
//         return solve(coins.length-1, amount, coins);
        
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         int coins[] = {1,2,5};
//         System.out.println(s.change(5, coins));
//     }
// }


//Approach 2: Recursion + Memoization
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)
// import java.util.*;
// class Solution {
//     static int solve(int index, int amount, int coins[], int [][]dp){
//         if(index==0){
//             //we have been into last index, hence we will check if the remaining target can be acheived by coins[0] or not
//             if(amount%coins[0]==0) return 1;
//             else return 0;
//         }
//         if(dp[index][amount]!=-1)return dp[index][amount];
//         int notPick = solve(index-1, amount, coins, dp);
//         int pick =0;
//         if(coins[index]<=amount){
//             pick =  solve(index, amount-coins[index], coins, dp);
//         }
//         return dp[index][amount]=pick + notPick;
//     }
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int dp[][] = new int[n][amount+1];
//         for(int row[]: dp){
//             Arrays.fill(row, -1);
//         }
//         return solve(coins.length-1, amount, coins, dp);
        
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         int coins[] = {1,2,5};
//         System.out.println(s.change(5, coins));
//     }
// }


//Approach 3: Iterative + Memoization
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int dp[][] = new int[n][amount+1];
//         for(int i =0; i<=amount; i++){
//             if(i%coins[0]==0) dp[0][i]=1;
//         }
//         for(int index =1; index<n;index++){
//             for(int target=0; target<=amount; target++)
//             {
//                 int notPick = dp[index-1][target];
//                 int pick =0;
//                 if(coins[index]<=target){
//                     pick =  dp[index][target-coins[index]];
//                 }
//                  dp[index][target]=pick + notPick;
//             }
//         }
//         return dp[n-1][amount];
        
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         int coins[] = {1,2,5};
//         System.out.println(s.change(5, coins));
//     }
// }

//Approach 4: Iterative + Memoization + Space Optimization
//Time Complexity: O(n^2)
//Space Complexity: O(n)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for(int i =0; i<=amount; i++){
            if(i%coins[0]==0) prev[i]=1;
        }
        for(int index =1; index<n;index++){
            int curr[] = new int[amount+1];
            for(int target=0; target<=amount; target++)
            {
                int notPick = prev[target];
                int pick =0;
                if(coins[index]<=target){
                    pick =  curr[target-coins[index]];
                }
                 curr[target]=pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
        
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int coins[] = {1,2,5};
        System.out.println(s.change(5, coins));
    }
}