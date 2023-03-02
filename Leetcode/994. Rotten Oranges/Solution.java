//Problem link: https://leetcode.com/problems/rotting-oranges/description/
import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length ==0 || grid==null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh_count= 0;
        for( int i =0; i<m ; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] ==2 )
                {
                    q.offer(new int[]{i, j});//we will store the cell value of rotten oranges in queue to apply bfs
                }
                else if(grid[i][j] == 1){
                    fresh_count++;//fresh count will count the total number of fresh fruit available initially
                }
            }
        }
        if(fresh_count==0) return 0;
        int time_count =0;
        while(!q.isEmpty()&& fresh_count>0){
            time_count++;
            int size = q.size();
            
            for(int i=0; i<size; i++){
                int[] currentCell = q.poll();
                for(int [] dir: dirs){
                    int row = currentCell[0]+ dir[0];
                    int col= currentCell[1]+dir[1];
                    if(row>=0 && row<m && col>=0 && col<n && grid[row][col]==1){
                        grid[row][col]=2;//make the neighbour rotten
                        q.offer(new int[]{row, col});
                        fresh_count--; //decrease the number of fresh count 
                        
                    }
                }
            }
        }
        return fresh_count==0?time_count:-1;
        
    }

    public static void main(String [] args){

        int [][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        Solution s = new Solution();
        int ans = s.orangesRotting(grid);
        System.out.println(ans);
    }


}