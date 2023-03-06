//Problem link: 
//https://leetcode.com/problems/number-of-enclaves/
import java.util.*;
class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        Queue<int[]> q= new LinkedList<>();
        //getting 1s on the edges
        for(int i =0; i<m; i++){
           if(grid[i][0]==1){
               q.offer(new int[]{i, 0});
               grid[i][0]=0;
           }
           if(grid[i][n-1]==1){
               q.offer(new int[]{i, n-1});
               grid[i][n-1]=0;
           }
        }
        for(int i =0; i<n; i++){
           if(grid[0][i]==1){
               q.offer(new int[]{0, i});
                grid[0][i]=0;
           }
           if(grid[m-1][i]==1){
               q.offer(new int[]{m-1, i});
               grid[m-1][i]=0;
           }
        }
        while(!q.isEmpty()){
            int []currentCell = q.poll();
            for(int []dir: dirs){
                int row = currentCell[0]+ dir[0];
                int col = currentCell[1]+ dir[1];
                if(row>=0 && col>=0 && row<m && col<n&& grid[row][col]==1){
                    grid[row][col]=0;
                    q.offer(new int[]{row, col});
                }
            }
        }
        int count=0;
        for(int i =0; i<m; i++){
            for(int j =0;j<n; j++){
                if(grid[i][j]==1)count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [][]grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(s.numEnclaves(grid));
    }
}