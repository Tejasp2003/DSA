class Solution {
    private final int MOD = 1000000007;
    private int solve(int n, int m, int k, int maxSoFar, int[][][] dp){
        if(n==0){
            if(k==0) return 1;
            return 0;
        }
        if(dp[n][k][maxSoFar]!=-1) return dp[n][k][maxSoFar];
        int ans =0;
        for(int i =1; i<=m; i++){
            if(k>0 && i>maxSoFar){
                ans=  (ans+solve(n-1, m, k-1, i, dp ))%MOD;
            }
            else if(i<=maxSoFar){
                ans = (ans+ solve(n-1, m, k, maxSoFar, dp)) %MOD;
            }
        }
        return dp[n][k][maxSoFar]= ans %MOD;
    }
    
    public int numOfArrays(int n, int m, int k) {
        int dp[][][] = new int[n+1][k+1][m+1];
        for(int[][] rows: dp){
            for(int row[] : rows){
                Arrays.fill(row, -1);
            }
        }
        return solve(n, m, k, 0, dp);
        
    }
}

