import java.util.Arrays;
class Solution {
    public int[] getAverages(int[] nums, int k) {
        // Get the length of the input array
        int n = nums.length;
        
        // Calculate the window size
        int windowSize = 2 * k + 1;
        
        // Variable to store the sum of the current window
        long windowSum = 0;
        
        // Create an array to store the result
        int[] result = new int[n];
        
        // Fill the result array with -1 as the default value
        Arrays.fill(result, -1);
        
        // If the input array is smaller than the window size, return the default result
        if (n < windowSize)
            return result;
        
        // Iterate through each element of the input array
        for (int i = 0; i < n; i++) {
            // Add the current element to the window sum
            windowSum += nums[i];
            
            // If the window has reached its maximum size, subtract the element that is going out of the window
            if (i - windowSize >= 0) {
                windowSum -= nums[i - windowSize];
            }
            
            // If the current index is at or beyond the window size, calculate the average and store it in the result array
            if (i >= windowSize - 1) {
                result[i - k] = (int) (windowSum / windowSize);
            }
        }
        
        // Return the result array
        return result;
    }

    public static void main(String [] args){
        Solution sol = new Solution();
        int[] nums = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 3;
        int[] result = sol.getAverages(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
