import java.util.*;

class Solution {

    private int solve(int index1, int index2, int[] nums1, int[] nums2) {
        int take = Integer.MIN_VALUE;
        int notTake = Integer.MAX_VALUE;
        if (index1 == nums1.length || index2 == nums2.length) {
            return 0;
        }
        if (nums1[index1] == nums2[index2]) {
            take = 1 + solve(index1 + 1, index2 + 1, nums1, nums2);
        }
        notTake = Math.max(solve(index1 + 1, index2, nums1, nums2), solve(index1,
                index2 + 1, nums1, nums2));
        return Math.max(take, notTake);

    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return solve(0, 0, nums1, nums2);
    }

    // dp + memoisation

    private int solve(int index1, int index2, int[] nums1, int[] nums2, int dp[][]) {
        int take = Integer.MIN_VALUE;
        int notTake = Integer.MAX_VALUE;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (index1 == nums1.length || index2 == nums2.length) {
            return 0;
        }
        if (nums1[index1] == nums2[index2]) {
            take = 1 + solve(index1 + 1, index2 + 1, nums1, nums2, dp);
        }
        notTake = Math.max(solve(index1 + 1, index2, nums1, nums2, dp), solve(index1,
                index2 + 1, nums1, nums2, dp));
        return dp[index1][index2] = Math.max(take, notTake);

    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n + 1][m + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return solve(0, 0, nums1, nums2, dp);
    }

    // dp + tabulation

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n + 1][m + 1];

        for (int index1 = n - 1; index1 >= 0; index1--) {
            for (int index2 = m - 1; index2 >= 0; index2--) {
                if (nums1[index1] == nums2[index2]) {
                    dp[index1][index2] = 1 + dp[index1 + 1][index2 + 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 + 1][index2], dp[index1][index2 + 1]);
                }
            }

        }
        return dp[0][0];
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums1 = { 1, 4, 2 };
        int[] nums2 = { 1, 2, 4 };
        System.out.println(s.maxUncrossedLines(nums1, nums2));
    }
}