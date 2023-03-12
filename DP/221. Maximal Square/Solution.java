//Problem Link: 
//https://leetcode.com/problems/maximal-square/

import java.util.*;

//Approach 1: Recursion

//Intution:
//1. We will start from the first row and first column and check if the element is 1 or not.
//2. If the element is 1, we will call the recursive function to check the size of the square.
//3. The recursive function will check the size of the square by checking the size of the square in the next row, next column and next row and next column.
//4. The size of the square will be the minimum of the three values + 1.
//5. We will return the maximum of all the squares.

//Time Complexity: O(3^mn)
//Space Complexity: O(mn)

// class Solution {
//     private int solve(int row, int col, char[][] matrix){
//         int m = matrix.length;
//         int n = matrix[0].length;
//         if(row>=m || col>=n || matrix[row][col]== '0'){
//             return 0;
//         }
//         return 1+ Math.min(solve(row+1, col, matrix), Math.min(solve(row+1, col+1, matrix), solve(row, col+1, matrix)));
//     }
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int ans= Integer.MIN_VALUE;
//         for(int row =0; row<m; row++){
//             for(int col =0; col<n; col++){
//                 if(matrix[row][col]== '1'){
//                     ans = Math.max(ans, solve(row, col, matrix));
//                 }
//             }
//         }
//         return ans == Integer.MIN_VALUE?0:ans*ans;
//     }

//     public static void main(String[] args) {
//         char[][] matrix = {
//             {'1', '0', '1' ,'0', '0'},
//             {'1', '0', '1' ,'1', '1'},
//             {'1', '1', '1' ,'1', '1'},
//             {'1', '0', '0' ,'1', '0'}
//         };
//         Solution s = new Solution();
//         System.out.println(s.maximalSquare(matrix));

//     }
// }

//Approach 2: Memoisation

//Time Complexity: O(mn)
//Space Complexity: O(mn)

// class Solution {
//     private int solve(int row, int col, char[][] matrix, int[][] dp){
//         int m = matrix.length;
//         int n = matrix[0].length;
//         if(row>=m || col>=n || matrix[row][col]== '0'){
//             return 0;
//         }
//         if(dp[row][col]!=-1)return dp[row][col];
//         return dp[row][col]= 1+ Math.min(solve(row+1, col, matrix, dp), Math.min(solve(row+1, col+1, matrix, dp), solve(row, col+1, matrix, dp)));
//     }
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int ans= Integer.MIN_VALUE;
//         int [][]dp= new int[m][n];
//         for(int[] row: dp){
//             Arrays.fill(row, -1);
//         }
//         for(int row =0; row<m; row++){
//             for(int col =0; col<n; col++){
//                 if(matrix[row][col]== '1'){
//                     ans = Math.max(ans, solve(row, col, matrix, dp));
//                 }
//             }
//         }
//         return ans == Integer.MIN_VALUE?0:ans*ans;
//     }

//     public static void main(String[] args) {
//         char[][] matrix = {
//             {'1', '0', '1' ,'0', '0'},
//             {'1', '0', '1' ,'1', '1'},
//             {'1', '1', '1' ,'1', '1'},
//             {'1', '0', '0' ,'1', '0'}
//         };
//         Solution s = new Solution();
//         System.out.println(s.maximalSquare(matrix));

//     }

// }

//Approach 3: Tabulation

//Time Complexity: O(mn)
//Space Complexity: O(mn)

// class Solution {
//     private int solve(int row, int col, char[][] matrix, int[][] dp){
//         int m = matrix.length;
//         int n = matrix[0].length;
//         if(row>=m || col>=n || matrix[row][col]== '0'){
//             return 0;
//         }
//         if(dp[row][col]!=-1)return dp[row][col];
//         return dp[row][col]= 1+ Math.min(solve(row+1, col, matrix, dp), Math.min(solve(row+1, col+1, matrix, dp), solve(row, col+1, matrix, dp)));
//     }
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int ans= Integer.MIN_VALUE;
//         int [][]dp= new int[m+1][n+1];
//         for(int row = m-1; row>=0; row--){
//             for(int col = n-1; col>=0; col--){
//                 if(matrix[row][col]=='1'){
//                     dp[row][col] = 1 + Math.min(dp[row][col+1],Math.min(dp[row+1][col+1],dp[row+1][col]));
//                     ans= Math.max(ans, dp[row][col]);
//                 }
//                 else{
//                     dp[row][col] =0;
//                 }
//             }
//         }
//         return ans*ans;
//     }
//         public static void main(String[] args) {
//         char[][] matrix = {
//             {'1', '0', '1' ,'0', '0'},
//             {'1', '0', '1' ,'1', '1'},
//             {'1', '1', '1' ,'1', '1'},
//             {'1', '0', '0' ,'1', '0'}
//         };
//         Solution s = new Solution();
//         System.out.println(s.maximalSquare(matrix));

//     }

// }

//Approach 4: Tabulation Optimised

//Time Complexity: O(mn)
//Space Complexity: O(n)

class Solution {
    private int solve(int row, int col, char[][] matrix, int[][] dp) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (row >= m || col >= n || matrix[row][col] == '0') {
            return 0;
        }
        if (dp[row][col] != -1)
            return dp[row][col];
        return dp[row][col] = 1 + Math.min(solve(row + 1, col, matrix, dp),
                Math.min(solve(row + 1, col + 1, matrix, dp), solve(row, col + 1, matrix, dp)));
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[] next = new int[n + 1];
        for (int row = m - 1; row >= 0; row--) {
            int[] curr = new int[n + 1];
            for (int col = n - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    curr[col] = 1 + Math.min(curr[col + 1], Math.min(next[col + 1], next[col]));
                    ans = Math.max(ans, curr[col]);
                } else {
                    curr[col] = 0;
                }
            }
            next = curr;
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        Solution s = new Solution();
        System.out.println(s.maximalSquare(matrix));

    }

}
