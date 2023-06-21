class Solution {

    // This method calculates the cost of moving each number in 'nums' array
    // to the 'target' value, based on the corresponding cost in 'cost' array.
    // It returns the total cost.
    private long findCost(int[] nums, int[] cost, long target){
        long res = 0;
        for(int i = 0; i < nums.length; i++){
            res += Math.abs(nums[i] - target) * cost[i];
        }
        return res;
    }

    // This method calculates the minimum cost required to make all the numbers
    // in 'nums' array equal. It uses binary search to find the optimal target value.
    public long minCost(int[] nums, int[] cost) {
        long left = 0;   // Initialize the left boundary of the binary search
        long right = 1000000;   // Initialize the right boundary of the binary search

        // Find the minimum and maximum values in the 'nums' array
        for(int num : nums){
            left = Math.min(num, left);
            right = Math.max(num, right);
        }

        long ans = findCost(nums, cost, 1);  // Set initial answer to the cost of moving all numbers to 1

        // Perform binary search until the left and right boundaries meet
        while(left < right){
            long mid = (left + right) / 2;  // Calculate the middle value

            long y1 = findCost(nums, cost, mid);         // Calculate the cost for moving to 'mid'
            long y2 = findCost(nums, cost, mid + 1);     // Calculate the cost for moving to 'mid + 1'

            ans = Math.min(y1, y2);  // Update the answer with the minimum cost

            // Adjust the boundaries based on the comparison of y1 and y2
            if(y1 < y2){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return ans;  // Return the minimum cost
    }

    public static void main(String [] args){
        Solution sol = new Solution();
        int[] nums = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int[] cost = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        long result = sol.minCost(nums, cost);
        System.out.println(result);
    }
}
