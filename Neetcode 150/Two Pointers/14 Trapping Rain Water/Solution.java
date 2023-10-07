// intution: Here in trapping rain water problem we will use two pointers. We will take two pointers left and right and we will also take two variables maxLeft and maxRight. We will move the left pointer if the height[left]<=height[right] and we will move the right pointer if height[left]>height[right]. We will also keep track of the maximum height on the left side and the maximum height on the right side. If the height of the current pointer is less than the maximum height on the left side, then we will add the difference between the maximum height on the left side and the height of the current pointer to the answer. If the height of the current pointer is less than the maximum height on the right side, then we will add the difference between the maximum height on the right side and the height of the current pointer to the answer. We will do this until left<=right.

// How we ensure that the water will not spill out of the container? We will ensure this by keeping track of the maximum height on the left side and the maximum height on the right side. If the height of the current pointer is less than the maximum height on the left side, then we will add the difference between the maximum height on the left side and the height of the current pointer to the answer. If the height of the current pointer is less than the maximum height on the right side, then we will add the difference between the maximum height on the right side and the height of the current pointer to the answer. We will do this until left<=right.

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft =0, maxRight=0;
        int left =0, right= n-1;
        int ans=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxLeft) maxLeft=height[left];
                else ans+= maxLeft-height[left];
                left++;
            }
            else{
                if(height[right]>=maxRight) maxRight= height[right];
                else ans+=maxRight-height[right];
                right--;
            }
        }
        return ans;
    }
}