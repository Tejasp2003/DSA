class Solution {
    static int getNumberOfCoins(int index, int[] coins, int target, int[][] dp) {
        if (target == 0) {
            return 0;
        }
        if (index == 0) {
            if (target % coins[index] == 0) {
                return target / coins[index];
            } else {
                return Integer.MAX_VALUE;

            }
        }
        if(dp[index][target]!=-1)return dp[index][target];

        int take = Integer.MAX_VALUE;
        int notTake = 0;
        notTake = getNumberOfCoins(index - 1, coins, target, dp);
        if (coins[index] <= target) {
            take = 1 + getNumberOfCoins(index, coins, target - coins[index], dp);
        }
        return dp[index][target]=Math.min(take, notTake);

    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int ans = getNumberOfCoins(coins.length-1, coins, amount, dp);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }