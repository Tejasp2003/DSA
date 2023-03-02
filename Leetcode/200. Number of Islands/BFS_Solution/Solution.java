//problem link: https://leetcode.com/problems/number-of-islands/description/
// Submission Detail: https://leetcode.com/submissions/detail/132100100/
import java.util.*;

public class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) { // If cell is a new island, increment count and start BFS traversal
                    count++;
                    Queue<int[]> queue = new LinkedList<>(); // Create a new queue for BFS
                    queue.offer(new int[]{i, j}); // Add the starting cell to the queue
                     // Mark the starting cell as visited
                    visited[i][j] = true;
                    bfs(grid, visited, queue, dirs); // Start BFS traversal
                }
            }
        }
        return count;
    }



    private void bfs(char[][] grid, boolean[][] visited, Queue<int[]> queue, int[][] dirs) {
        
        while (!queue.isEmpty()) { // Traverse all the cells in the current island using BFS
            int[] curr = queue.poll(); // Dequeue the current cell from the queue
          
            
            int row = curr[0];
            int col = curr[1];
            for (int[] dir : dirs) { // Traverse all the neighboring cells
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) { // If neighboring cell is a new island, add it to the queue and mark it as visited
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }



    public static void main(String[] args){

        char [][] grid ={
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        Solution s = new Solution();
        System.out.println(s.numIslands(grid));

    }
}
