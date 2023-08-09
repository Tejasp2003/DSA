// class Solution {
//     public boolean isMatch(String s, String p) {
//         return helper(s, p, 0, 0);
//     }
    
//     private boolean helper(String s, String p, int i, int j) {
//         if (j == p.length()) {
//             return i == s.length();
//         }
        
//         boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
//         if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
//             return helper(s, p, i, j + 2) || (firstMatch && helper(s, p, i + 1, j));
//         } else {
//             return firstMatch && helper(s, p, i + 1, j + 1);
//         }
//     }
// }


// memoised solution

class Solution {
    // Helper function for recursion with memoization
    private boolean helper(int i, int j, String s, String p, boolean[][] dp) {
        // Check if the result for this subproblem is already calculated and stored in dp array
        if (dp[i][j]) {
            return dp[i][j];
        }
        
        boolean ans;
        // Base case: If we have reached the end of pattern p
        if (j == p.length()) {
            // If we have also reached the end of string s, it's a match, otherwise not
            ans = i == s.length();
        } else {
            // Check if the current characters match or if there's a '.'
            boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            
            // If the next character is '*', handle repetition
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // Two choices: (1) Skip '*' and the preceding character, (2) Match the preceding character and consider it part of the repetition
                ans = (helper(i, j + 2, s, p, dp)) || (firstMatch && helper(i + 1, j, s, p, dp));
            } else {
                // Otherwise, simply move to the next characters in both strings
                ans = firstMatch && helper(i + 1, j + 1, s, p, dp);
            }
        }
        
        // Store the result of this subproblem in dp array
        dp[i][j] = ans;
        return ans;
    }
    
    // Entry point for the regular expression matching
    public boolean isMatch(String s, String p) {
        // Create a DP array to store subproblem results
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        // Start the recursion from the beginning of both strings
        return helper(0, 0, s, p, dp);
    }
}
