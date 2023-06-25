// class Solution {
//     // Recursive function to find the maximum height achievable for the billboard
//     public int findMaxHeight(int index, int[] rods, int leftSum, int rightSum) {
//         // Base case: reached the end of the array
//         if (index == rods.length) {
//             // Check if the left and right sums are equal
//             if (leftSum == rightSum) {
//                 // Return the left sum as the maximum achievable height
//                 return leftSum;
//             }
//             // If the sums are not equal, return 0
//             return 0;
//         }

//         // Option 1: Not considering the current rod
//         int notConsidered = findMaxHeight(index + 1, rods, leftSum, rightSum);

//         // Option 2: Considering the current rod in the left sum
//         int consideredInLeft = findMaxHeight(index + 1, rods, leftSum + rods[index], rightSum);

//         // Option 3: Considering the current rod in the right sum
//         int consideredInRight = findMaxHeight(index + 1, rods, leftSum, rightSum + rods[index]);

//         // Return the maximum height among the three options
//         return Math.max(Math.max(notConsidered, consideredInLeft), consideredInRight);
//     }

//     // Main method to calculate the tallest billboard height
//     public int tallestBillboard(int[] rods) {
//         // Start the recursive function from the beginning of the array with left and right sums initialized as 0
//         return findMaxHeight(0, rods, 0, 0);
//     }
// }

import java.util.*;


class Solution {

    private int solve(int index, int[] rods, int diff, int[][] dp, int n) {
        // Base case: If the index reaches the end of the rods array
        if (index == n) {
            // If the difference is 0, return 0 (valid height)
            if (diff == 0) return 0;
            // Otherwise, return a very small negative value as an invalid height marker
            return Integer.MIN_VALUE;
        }

        // Check if the result for the current index and difference is already computed and stored in the dp array
        if (dp[index][diff + 5000] != -1) return dp[index][diff + 5000];

        // Recursive calls for three options: not taking the current rod, taking it in the left sum, and taking it in the right sum
        int notTake = solve(index + 1, rods, diff, dp, n);
        int left = rods[index] + solve(index + 1, rods, diff + rods[index], dp, n);
        int right = rods[index] + solve(index + 1, rods, diff - rods[index], dp, n);

        // Choose the maximum height among the three options
        int maxHeight = Math.max(notTake, Math.max(left, right));

        // Store the computed result in the dp array at the corresponding index and difference
        dp[index][diff + 5000] = maxHeight;

        // Return the maximum height
        return maxHeight;
    }

    public int tallestBillboard(int[] rods) {
        int n = rods.length;

        // Create the dp array with dimensions [21][10001]
        int[][] dp = new int[21][10001];

        // Initialize the dp array with -1 (indicating that the result is not yet computed)
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        // Call the solve method to calculate the tallest billboard height and divide by 2 to get the height
        return (solve(0, rods, 0, dp, n)) / 2;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] rods = {1,2,3,6};
        System.out.println(sol.tallestBillboard(rods));
    }
}
