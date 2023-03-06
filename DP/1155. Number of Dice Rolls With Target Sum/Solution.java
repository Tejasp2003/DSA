//Problem link: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

//Problem Statement:
//You have d dice, and each die has f faces numbered 1, 2, ..., f.
//Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.

//Example
//Input:
// n = 1, k = 6, target = 3
//Output:
// 1
//Explanation:
//You throw one die with 6 faces.  There is only one way to get a sum of 3.

//Input:
// n = 2, k = 6, target = 7
//Output:
// 6
//Explanation:
//You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
//1+6, 2+5, 3+4, 4+3, 5+2, 6+1.


import java.util.*;
//Solution 1

//Recursive Solution

//intution:
// We can solve this problem using recursion. We can use each of the 'n' dice one by one and count the number of ways to achieve the target sum.
// For each dice, we can roll it from 1 to 'k' faces and recursively call the function to count the number of ways to achieve the target sum.
// We can use memoization to optimize the solution.

//Time Complexity: O(k^n)
//Space Complexity: O(n)




// class Solution {
//     static int mod = (int)1e9+7;
    
//     // Recursive function to count the number of ways to get 'target' sum using 'n' dice rolls with 'k' faces
//     static int solve(int n, int k, int target) {
//         // Base case: If we have used all 'n' dice rolls and achieved 'target' sum, return 1
//         if(n==0 ) {
//             if(target==0) return 1;
//             else return 0;
//         }
        
//         // Base case: If we have used all 'n' dice rolls but not achieved 'target' sum, return 0
//         // Also, if we have exceeded the target, return 0
//         if(target<0) return 0;
        
//         int count=0;
//         // Recursively roll each of the 'n' dice, one by one, and count the number of ways to achieve the target sum
//         for(int i =1;i<=k; i++){
//             count = (count+solve(n-1, k, target-i))%mod;
//         }
//         return count;
//     }
    
//     public int numRollsToTarget(int n, int k, int target) {
//         // Call the recursive function and return the result
//         return solve(n, k, target);
//    }
// }

//Solution 2: Memoisation

//intution:
// We can use memoization to optimize the solution. We can store the result of each subproblem in a 2D array and use it if we encounter the same subproblem again.
// here we have 2 parameter changing, n (no. of dice) and target. So we will make a 2d DP to store the values.

//Time Complexity: O(n*target*k)

//Space Complexity: O(n*target) + Auxiliary Stack Space



// class Solution {
//     static int mod = (int)1e9+7;
    
//     // Recursive function to count the number of ways to get 'target' sum using 'n' dice rolls with 'k' faces
//     static int solve(int n, int k, int target, int[][] dp) {
//         // Base case: If we have used all 'n' dice rolls and achieved 'target' sum, return 1
//         if(n==0 ) {
//             if(target==0) return 1;
//             else return 0;
//         }
        
//         // Base case: If we have used all 'n' dice rolls but not achieved 'target' sum, return 0
//         // Also, if we have exceeded the target, return 0
//         if(target<0) return 0;
        
//         // If the solution to this subproblem has already been computed, return it from the dp table
//         if(dp[n][target]!= -1) return dp[n][target];
        
//         int count=0;
//         // Recursively roll each of the 'n' dice, one by one, and count the number of ways to achieve the target sum
//         for(int i =1;i<=k; i++){
//             count = (count+solve(n-1, k, target-i, dp))%mod;
//         }
        
//         // Memoize the computed solution for this subproblem in the dp table
//         dp[n][target] = count;
        
//         return dp[n][target];
//     }
    
//     public int numRollsToTarget(int n, int k, int target) {
//         // Call the recursive function with memoization and return the result
//         int dp[][] = new int[n+1][target+1];
        
//         // Initialize the dp table with -1 values to mark all subproblems as unsolved
//         for(int[] arr: dp){
//             Arrays.fill(arr, -1);
//         }

//         return solve(n, k, target, dp);
//    }

//    public static void main(String[] args) {
//          Solution s = new Solution();
//          System.out.println(s.numRollsToTarget(30, 30, 500));
//    }
// }



//Solution 3: Tabulation

//intution:
// We can also solve this problem using tabulation. We can use a 2D array to store the result of each subproblem.
// We can use the result of the previous subproblems to solve the current subproblem.
// We can use the following recurrence relation to solve the problem:


//Time Complexity: O(n*target*k)
//Space Complexity: O(n*target)

// class Solution{
//     static int mod = (int)1e9+7;  // Define a constant for modulo arithmetic
    
//     public int numRollsToTarget(int n, int k, int target){
//         // Create a 2D array to store the result of each subproblem
//         int dp[][] = new int[n+1][target+1];
        
//         // Base case: If we have used all 'n' dice rolls and achieved 'target' sum, return 1
//         dp[0][0] = 1;
        
//         // Iterate over the dp table
//         for(int i=1; i<=n; i++){  // i represents the number of dice rolls used so far
//             for(int j=1; j<=target; j++){  // j represents the target sum we want to achieve
//                 // Iterate over the faces of the dice
//                 for(int face=1; face<=k; face++){
//                     // If the current face is less than or equal to the current target sum, we can use it to achieve the target sum
//                     if(face<=j){
//                         // Add the number of ways to achieve the target sum using the remaining dice rolls
//                         dp[i][j] = (dp[i][j] + dp[i-1][j-face])%mod;
//                         // dp[i][j] stores the number of ways to achieve sum 'j' using 'i' dice rolls
//                         // dp[i-1][j-face] stores the number of ways to achieve the remaining sum after using the current face
//                         // We add these two values to get the total number of ways to achieve the target sum 'j' using 'i' dice rolls
//                     }
//                 }
//             }
//         }
        
//         // Return the result
//         return dp[n][target];  // Return the number of ways to achieve the target sum using 'n' dice rolls
//     }

//     public static void main(String[] args) {
//          Solution s = new Solution();
//          System.out.println(s.numRollsToTarget(30, 30, 500));
//          // Test the solution with input values n=30, k=30, target=500 and print the result
//     }
// }

//Solution 4: Tabulation (Space Optimized)

//intution:
// We can optimize the space complexity of the solution by using a 1D array instead of a 2D array.
// We can use the result of the previous subproblems to solve the current subproblem.
// We can use the following recurrence relation to solve the problem:

//Time Complexity: O(n*target*k)
//Space Complexity: O(target)
class Solution{
    static int mod = (int)1e9+7;  // Define a constant for modulo arithmetic
    
    public int numRollsToTarget(int n, int k, int target){
        // Create a 2D array to store the result of each subproblem
        int prev[] = new int[target+1];
        
        
        
        // Base case: If we have used all 'n' dice rolls and achieved 'target' sum, return 1
        prev[0] = 1;
        
        // Iterate over the dp table
        for(int i=1; i<=n; i++){  // i represents the number of dice rolls used so far
            int curr[] = new int[target+1];
            for(int j=1; j<=target; j++){  // j represents the target sum we want to achieve
                // Iterate over the faces of the dice
                for(int face=1; face<=k; face++){
                    // If the current face is less than or equal to the current target sum, we can use it to achieve the target sum
                    if(face<=j){
                        // Add the number of ways to achieve the target sum using the remaining dice rolls
                        curr[j] = (curr[j] + prev[j-face])%mod;
                        // dp[i][j] stores the number of ways to achieve sum 'j' using 'i' dice rolls
                        // dp[i-1][j-face] stores the number of ways to achieve the remaining sum after using the current face
                        // We add these two values to get the total number of ways to achieve the target sum 'j' using 'i' dice rolls
                    }
                }
            }
            prev = curr;

        }
        
        // Return the result
        return prev[target];  // Return the number of ways to achieve the target sum using 'n' dice rolls
    }

    public static void main(String[] args) {
         Solution s = new Solution();
         System.out.println(s.numRollsToTarget(30, 30, 500));
         // Test the solution with input values n=30, k=30, target=500 and print the result
    }
}