import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // if(mat== null || mat.length==0) return 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] grid = mat;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i, j});//add cell having 0, as we start bfsfrom that cells
                }
                else{
                    grid[i][j]=-1;//making all cells -1 having value other 0 
                }
            }
        }
        int level =0;
        while(!q.isEmpty()){
            level++;
            int size= q.size();
            while(size-->0){
                int[] currentCell = q.poll();
                for(int [] dir: dirs){
                    int row = currentCell[0]+ dir[0];
                    int col = currentCell[1]+ dir[1];
                    // if(row>=0 && row<m && col>=0 && col<n && grid[row][col]==-1){
                    //     grid[row][col]= level;
                    //     q.offer(new int[]{row, col});
                    // }
                    if(row<0 || row>=m || col<0 || col>=n || grid[row][col]!=-1) continue;
                    grid[row][col]= level;
                    q.offer(new int[]{row, col});
                }
            }

            
        }

        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };
        Solution s = new Solution();
        int[][] result = s.updateMatrix(grid);
        System.out.println(Arrays.deepToString(result));
    }
}