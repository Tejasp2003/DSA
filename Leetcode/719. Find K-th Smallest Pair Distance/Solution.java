class Solution {
    private int countPairs(int[] nums, int dif) {
        int count = 0;
        int n = nums.length;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > dif) {
                left++;
            }
            count += right - left;
        }

        return count;
    }
    
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int start = 0;
        int end = nums[n - 1] - nums[0];
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            int pairsCount = countPairs(nums, mid);
            
            if (pairsCount < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}