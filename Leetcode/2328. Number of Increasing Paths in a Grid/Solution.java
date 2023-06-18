import java.util.Arrays;

class Solution {
    private int[][] dp; // Dynamic programming array to store the computed results
    private int mod = (int) 1e9 + 7; // Modulus value for the final result

    // Recursive helper function to find the number of valid paths from (i, j) to the bottom-right cell
    private int solve(int i, int j, int[][] grid) {
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid

        if (dp[i][j] != -1) { // If the value is already computed and stored in dp, return it
            return dp[i][j];
        }

        int count = 0; // Variable to count the number of valid paths

        // Check if moving up from the current cell is a valid move
        if (i > 0 && grid[i][j] < grid[i - 1][j]) {
            count += solve(i - 1, j, grid) + 1; // Recursively compute the number of valid paths from the cell above
        }

        // Check if moving down from the current cell is a valid move
        if (i < n - 1 && grid[i][j] < grid[i + 1][j]) {
            count += solve(i + 1, j, grid) + 1; // Recursively compute the number of valid paths from the cell below
        }

        // Check if moving left from the current cell is a valid move
        if (j > 0 && grid[i][j] < grid[i][j - 1]) {
            count += solve(i, j - 1, grid) + 1; // Recursively compute the number of valid paths from the cell on the left
        }

        // Check if moving right from the current cell is a valid move
        if (j < m - 1 && grid[i][j] < grid[i][j + 1]) {
            count += solve(i, j + 1, grid) + 1; // Recursively compute the number of valid paths from the cell on the right
        }

        count = count % mod; // Apply modulus to keep the result within the specified range

        dp[i][j] = count; // Store the computed result in the dp array
        return count;
    }

    // Main function to count the total number of valid paths in the grid
    public int countPaths(int[][] grid) {
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid
        dp = new int[n][m]; // Initialize the dp array to store the computed results

        for (int[] row : dp) {
            Arrays.fill(row, -1); // Fill the dp array with -1 initially to indicate that the result is not computed yet
        }

        int res = 0; // Variable to store the final result

        // Iterate through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += solve(i, j, grid) + 1; // Compute the number of valid paths from the current cell
                res %= mod; // Apply modulus to keep the result within the specified range
            }
        }

        return res; // Return the final result
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(sol.countPaths(grid));
    }
}
