//Problem link: https://leetcode.com/problems/flood-fill/description/
import java.util.*;
class Solution {

static void dfs(int row, int col, int initialColor, int[][] image, int color, int[][] dirs,int[][] ans){
    int m= image.length;
    int n = image[0].length;
    ans[row][col] = color;

    for(int [] dir: dirs){
        int currentRow = row+dir[0];
        int currentCol =col+dir[1];
        if(currentRow>=0 && currentRow<m && currentCol>=0 && currentCol<n&& image[currentRow][currentCol]==initialColor && image[currentRow][currentCol] != color){
            dfs(currentRow, currentCol, initialColor, image, color, dirs, ans);
        }

    }
}

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int [][] ans = image;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        dfs(sr,sc, initialColor, image, color,dirs, ans);
        return ans;

    }

    public static void main(String[] args){
        int [][] image ={
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        Solution s = new Solution();
        int [][] ans = s.floodFill(image, 1, 1, 2);

        System.out.println(Arrays.deepToString(ans));




    
    }
}