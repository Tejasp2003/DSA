//problem link: https://leetcode.com/problems/minimum-path-sum/description/
import java.util.*;
//Approach 1: Recursion
//Time Complexity: O(2^(m+n))
//Space Complexity: O(m+n)

// class Solution {
//     static int solve(int row, int col, int grid[][]){
//         int m = grid.length;
//         int n = grid[0].length;
//         if(row==m-1 && col == n-1) return grid[row][col];
//         if(row>=m || col>=n) return (int)Math.pow(10, 9);

//         int down = grid[row][col] + solve(row+1, col, grid);
//         int right = grid[row][col] + solve(row, col+1, grid);
//         return Math.min(down, right);
//     }
//     public int minPathSum(int[][] grid) {
//         return solve(0, 0, grid);
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
//         System.out.println(s.minPathSum(grid));
//     }
// }


//Approach 2: Recursion with Memoization
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

// class Solution {
//     static int solve(int row, int col, int grid[][], int[][] dp){
//         int m = grid.length;
//         int n = grid[0].length;
//         if(row==m-1 && col == n-1) return grid[row][col];
//         if(row>=m || col>=n) return (int)Math.pow(10, 9);
//         if(dp[row][col]!=-1) return dp[row][col];

//         int down = grid[row][col] + solve(row+1, col, grid, dp);
//         int right = grid[row][col] + solve(row, col+1, grid, dp);
//         return dp[row][col]=Math.min(down, right);
//     }
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int dp[][] = new int[m][n];
//         for(int [] row: dp){
//             Arrays.fill(row, -1);
//         }
//         return solve(0, 0, grid, dp);
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
//         System.out.println(s.minPathSum(grid));
//     }
// }

//Approach 3: Iterative
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

// class Solution {
   
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int dp[][] = new int[m][n];
//         for(int row =m-1; row>=0; row--){
//             for(int col = n-1; col>=0; col--){
//                 if(row==m-1 && col==n-1) dp[row][col]= grid[row][col];
//                 else
//                 {
//                     int down = grid[row][col] ;
//                     if(row<m-1)down += dp[row+1][col];
//                     else down = Integer.MAX_VALUE;
//                     int right = grid[row][col];
//                     if(col<n-1)right+=dp[row][col+1];
//                     else right = Integer.MAX_VALUE;
//                     dp[row][col]=Math.min(down, right);
//                 }
//             }
//         }
//         return dp[0][0];
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
//         System.out.println(s.minPathSum(grid));
//     }
// }


//Approach 4: Iterative with Space Optimization
//Time Complexity: O(m*n)
//Space Complexity: O(n)

class Solution {
   
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int next[] = new int[n];
        for(int row =m-1; row>=0; row--){
            int curr[] = new int[n];
            for(int col = n-1; col>=0; col--){
                if(row==m-1 && col==n-1) curr[col]= grid[row][col];
                else
                {
                    int down = grid[row][col] ;
                    if(row<m-1)down += next[col];
                    else down = Integer.MAX_VALUE;
                    int right = grid[row][col];
                    if(col<n-1)right+=curr[col+1];
                    else right = Integer.MAX_VALUE;
                    curr[col]=Math.min(down, right);
                }
            }
            next=curr;
        }
        return next[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(s.minPathSum(grid));
    }
}
