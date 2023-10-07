// intution: Here we will first calculate the area with the maximum width possible i.e. j-i. Then we will move the pointer which is pointing to the smaller height. This is because if we move the pointer pointing to the larger height, then the area will decrease as the width will decrease. So we will move the pointer pointing to the smaller height. This way we will get the maximum area possible.

class Solution {
    public int maxArea(int[] heights) {
        int i =0; int j = heights.length-1;
        int area = 0;
        while(i<j){
            area = Math.max(area, Math.min(heights[i], heights[j])*(j-i));
            if(heights[i]<heights[j]){
                i++;
            }
            else{
                j--;
            } 
        }
        return area;
    }
    public static void main(String[] args){
        int[] heights = {1,8,6,2,5,4,8,3,7};
        Solution obj = new Solution();
        int ans = obj.maxArea(heights);
        System.out.println(ans);
    }
}