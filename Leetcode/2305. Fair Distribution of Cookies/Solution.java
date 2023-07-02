class Solution {
    int ans; // Variable to store the minimum number of cookies
    int count[]; // Array to keep track of the count of cookies distributed to each person

    public int distributeCookies(int[] cookies, int k) {
        ans = Integer.MAX_VALUE; // Initialize ans to the maximum value possible
        count = new int[k]; // Initialize the count array with length k
        backtrack(0, cookies, k); // Call the backtrack function to find the minimum distribution
        return ans; // Return the minimum number of cookies required
    }

    public void backtrack(int index, int[] cookies, int k) {
        int n = cookies.length; // Get the length of the cookies array

        if (index >= n) { // Base case: If all the cookies have been distributed
            int max = 0;
            for (int num : count) {
                max = Math.max(max, num); // Find the maximum number of cookies received by any person
            }
            ans = Math.min(ans, max); // Update the minimum number of cookies required if necessary
            return;
        }

        for (int i = 0; i < k; i++) { // Iterate over each person
            count[i] += cookies[index]; // Give the ith person the current cookie
            backtrack(index + 1, cookies, k); // Recursively backtrack to distribute the remaining cookies
            count[i] -= cookies[index]; // Undo the distribution for backtracking
            if (count[i] == 0)
                return; // If a person doesn't receive any cookies, terminate the loop for that person
        }
    }

    public static void main(String [] args){
        Solution sol = new Solution();
        int [] cookies = {1,2,3,4,5,6,7,8,9};
        int k = 8;
        System.out.println(sol.distributeCookies(cookies, k));
    }
}
