import java.util.HashMap;


class Solution{
public int longestArithmeticSequenceLength(int[] nums) {
    if (nums.length <= 1) return nums.length;

    int longestLength = 0;
    // dp array is an array of hashmaps.
    // The map for each index maintains an element of the form:
    //   (difference, length of maximum chain ending at that index with that difference).        
    HashMap<Integer, Integer>[] dp = new HashMap[nums.length];

    for (int i = 0; i < nums.length; ++i) {
        // Initialize the map for each index.
        dp[i] = new HashMap<>();
    }

    for (int i = 1; i < nums.length; ++i) {
        int currentNum = nums[i];

        for (int j = 0; j < i; ++j) {
            int difference = currentNum - nums[j];
            // We have a minimum chain length of 2 now,
            // assuming (nums[j], currentNum) with the difference 'difference'
            // forms a chain of length 2 by default.
            int chainLength = 2;

            if (dp[j].containsKey(difference)) {
                // If we had already seen the difference 'difference' at index j,
                // then we can extend the chain by adding currentNum to it.
                // Hence, we increase the length of the chain by 1.
                chainLength = dp[j].get(difference) + 1;
            }

            // Update the maximum chain length for the difference 'difference' at index i.
            dp[i].put(difference, chainLength);

            // Update the global maximum length.
            longestLength = Math.max(longestLength, chainLength);
        }
    }

    return longestLength;
}
public static void main(String[] args){
    Solution sol = new Solution();
    int[] nums = {3,6,9,12};
    System.out.println(sol.longestArithmeticSequenceLength(nums));
}
}