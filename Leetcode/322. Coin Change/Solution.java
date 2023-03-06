import java.util.*;

//problem statement:
//You are given n coins, where the value of the ith coin is coins[i]. You want to make a value target. You are given an integer array coins that represents the values of the n coins and an integer target that represents the target value.
//You want to make a value target. You are given an integer array coins that represents the values of the n coins and an integer target that represents the target value.
//You can use each coin an infinite number of times. Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return -.;
//You may assume that you have an infinite number of each kind of coin.

//Solution 1: Recursive Solution
//Intution:
//Here, we have given a coins array, which has different values of coins. We have given an integer variable target, and by using the coins array, we have to add the coins that make it up to the target. Here we have an infinite number of coins.
//So, we can use each of the coins one by one and count the number of ways to achieve the target sum.
//For each coin, we have two options, either we can select the coin or we can ignore the coin. Hence we can take the coin or not take the coin.
//If we take the coin then we have to reduce the value of the target by the amount of the coin and call the recursive getNumberOfCoins function. Here we stay on the same index as having an infinite supply coin, so we can take the same coin as many times as we want. we can only take the coin if its value is lower than or equal to the target. Hence the taken call will be:
//take = 1 + getNumberOfCoins(index, coins, target - coins[index]);


//If we don't take the coin, then we have to reduce the index by 1 and call the recursive getNumberOfCoins function. Here we don't reduce the target, as we don't take the coin. Here we don't take the coin, so we have to reduce the index by 1. Hence the notTake call will be:
//notTake = getNumberOfCoins(index - 1, coins, target);

//Time Complexity: O(2^n)
//Space Complexity: O(n)

// class Solution {
//     // This is a static method that takes the index of the coin array, the coin array itself and the target amount as input parameters
// It returns the minimum number of coins required to make up the target amount using the coins in the coins array
// static int getNumberOfCoins(int index, int[] coins, int target) {
//     // If the target amount is already achieved, we don't need to do anything and return 0
//     if (target == 0) {
//         return 0;
//     }
//     // If the index of the coin is at the first element and the target amount is not divisible by the value of the coin at the first index, we cannot achieve the target
//     // So, we return Integer.MAX_VALUE to indicate that it is not possible to make up the target using the coins array
//     if (index == 0) {
//         if (target % coins[index] == 0) {
//             return target / coins[index];
//         } else {
//             return Integer.MAX_VALUE;
//         }
//     }
    
//     // We initialize two variables take and notTake
//     // We set the notTake variable to the result of calling the getNumberOfCoins method recursively with the index reduced by 1 and the target remaining the same
//     int notTake = getNumberOfCoins(index - 1, coins, target);
    
//     // We set the take variable to Integer.MAX_VALUE initially
//     // If the value of the coin at the current index is less than or equal to the target, then we call the getNumberOfCoins method recursively with the same index and reduced target value (target - coin value)
//     // We add 1 to the result because we are taking one coin from the current index
//     if (coins[index] <= target) {
//         take = 1 + getNumberOfCoins(index, coins, target - coins[index]);
//     }
    
//     // We return the minimum value of take and notTake
//     return Math.min(take, notTake);
// }

// // This method takes the coin array and the target amount as input parameters
// // It calls the getNumberOfCoins method to get the minimum number of coins required to make up the target amount
// // If it is not possible to achieve the target using the coins array, then it returns -1
// public int coinChange(int[] coins, int amount) {
//     int ans = getNumberOfCoins(coins.length-1, coins, amount);
//     if (ans == Integer.MAX_VALUE) {
//         return -1;
//     }
//     return ans;
// }

// // This is the main method where we take input from the user
// // We take the number of coins, target amount and the values of the coins as input from the user
// // We create an object of the Solution class and call the coinChange method with the input parameters
// // Finally, we print the result
// public static void main(String[] args) {
//     Solution s = new Solution();
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();
//     int target = sc.nextInt();
//     int[] coins = new int[n];
//     for (int i = 0; i < n; i++) {
//         coins[i] = sc.nextInt();
//     }
//     System.out.println(s.coinChange(coins, target));
// }

// }

//Solution 2: Memoization


//Time Complexity: O(n*target)
//Space Complexity: O(n*target)


// class Solution {
//     static int getNumberOfCoins(int index, int[] coins, int target, int[][] dp) {
//         // Base case: if target amount is 0, then no coins are needed
//         if (target == 0) {
//             return 0;
//         }
//         // Base case: if only one coin is available
//         // check if the amount is divisible by the coin, if yes return the quotient as number of coins needed,
//         // if not return a high value, signifying that it is not possible to make change for the given amount
//         if (index == 0) {
//             if (target % coins[index] == 0) {
//                 return target / coins[index];
//             } else {
//                 return (int)Math.pow(10,9);
//             }
//         }
//         // check if the sub-problem has already been computed and stored in dp table
//         if(dp[index][target]!=-1)return dp[index][target];

//         // two possibilities: take or not take the coin at the current index
//         // if the coin at the current index is greater than target amount, then notTake will be returned (cannot take the coin)
//         // else check for both possibilities, and store the minimum value in dp table for future use
//         int take = (int)Math.pow(10,9); //initialize take to a high value, which signifies that it is not possible to make change for the given amount
//         int notTake = 0;
//         notTake = getNumberOfCoins(index - 1, coins, target, dp);
//         if (coins[index] <= target) {
//             take = 1 + getNumberOfCoins(index, coins, target - coins[index], dp);
//         }
//         dp[index][target] = Math.min(take, notTake);
//         return dp[index][target];
//     }

//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int dp[][] = new int[n][amount+1];
//         //initialize dp table with -1
//         for(int[] arr: dp){
//             Arrays.fill(arr, -1);
//         }
//         // get number of coins needed to make the given amount
//         int ans = getNumberOfCoins(coins.length-1, coins, amount, dp);
//         // if the minimum coins required is greater than the maximum value in the dp table (signifying it is not possible to make change)
//         // then return -1
//         if (ans == (int)Math.pow(10,9)) {
//             return -1;
//         }
//         return ans;
//     }
// }


//Solution 3: Tabulation


//Time Complexity: O(n*target)
//Space Complexity: O(n*target)



// class Solution{
//     // This method returns the minimum number of coins needed to make up the given amount using the given coins.
// public int coinChange(int[] coins, int amount) {
    
//     // Get the length of the coins array.
//     int n = coins.length;
    
//     // Initialize a 2D array to store the intermediate results.
//     int dp[][] = new int[n][amount+1];
    
//     // Fill the array with -1 to indicate that the value has not been computed yet.
//     for(int[] arr: dp){
//         Arrays.fill(arr, -1);
//     }
    
//     // Base case: if the target amount is divisible by the first coin, use only the first coin.
//     for(int target = 0; target<=amount; target++){
//         if(target%coins[0]==0){
//             dp[0][target]= target/coins[0];
//         }
//         // Otherwise, it is not possible to make up the amount using only the first coin.
//         else{
//             dp[0][target] =(int)Math.pow(10,9) ;
//         }
//     }
    
//     // Fill the array using dynamic programming.
//     for(int index=1; index<n; index++){
//         for(int target =0; target<=amount; target++){
            
//             // Initialize take and notTake to large values.
//             int take = (int)Math.pow(10,9);
//             int notTake = 0;
            
//             // Case 1: not taking the current coin.
//             notTake = dp[index - 1][target];
            
//             // Case 2: taking the current coin if possible.
//             if (coins[index] <= target) {
//                 take = 1 + dp[index][target - coins[index]];
//             }
            
//             // Choose the minimum between take and notTake.
//             dp[index][target] = Math.min(take, notTake);
//         }
//     }
    
//     // The answer is the value in the last row and last column of the dp array.
//     int ans = dp[n-1][amount];
    
//     // If it is not possible to make up the amount using the given coins, return -1.
//     if (ans == (int)Math.pow(10,9)) {
//         return -1;
//     }
    
//     // Otherwise, return the minimum number of coins needed.
//     return ans;
// }

// // Main method for testing the solution.
// public static void main(String[] args) {
//     Solution s = new Solution();
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();
//     int target = sc.nextInt();
//     int[] coins = new int[n];
//     for (int i = 0; i < n; i++) {
//         coins[i] = sc.nextInt();
//     }
//     System.out.println(s.coinChange(coins, target));
// }

// }

//Solution 4: Tabulation (Space Optimized)


//Time Complexity: O(n*target)
//Space Complexity: O(target)

class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int[amount+1];
       
        for(int target = 0; target<=amount; target++){
            if(target%coins[0]==0){
                prev[target]= target/coins[0];
            
            }
            else{
                prev[target] =(int)Math.pow(10,9) ;
            }
        }
        for(int index=1; index<n; index++){
            int curr[] = new int[amount+1];
            for(int target =0; target<=amount; target++){
                
                int take = (int)Math.pow(10,9);
                int notTake = 0;
                notTake = prev[target];
                if (coins[index] <= target) {
                    take = 1 + curr[target - coins[index]];
                }
                curr[target] = Math.min(take, notTake);
              
            }
            prev = curr;
        }


       
        int ans = prev[amount];
        if (ans == (int)Math.pow(10,9)) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.println(s.coinChange(coins, target));
    }
}