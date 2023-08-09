import java.util.Arrays;

class Solution{
  public int minimizeMax(int[] nums, int p){
    int n = nums.length;
    Arrays.sort(nums);
    int start=0, end=nums[n-1]-nums[0];
    int ans =0;
    while(start<=end){
        int mid = start+(end-start)/2;
        int count = 0;
        for(int i =1; i<n; i++){
            if(nums[i]-nums[i-1]<=mid){
                count ++;
                i++;
                if(count>=p) break;
            }
        }
        if(count>=p){
            ans = mid;
            end = mid-1;
        }
        else{
            start = mid+1;
        }
    }
    return ans;
  }
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {4,2,1,2};
    int p = 1;
    System.out.println(s.minimizeMax(nums, p));
  }
}