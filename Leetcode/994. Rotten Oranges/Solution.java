
 //Problem link: https://leetcode.com/problems/rotting-oranges/description/
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int fresh_count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });

                } else if (grid[i][j] == 1) {
                    fresh_count++;
                }
            }
        }
        int count = 0;
        while (!q.isEmpty() & fresh_count > 0) {
            count++;
            int size = q.size();
            while (size > 0) {

                size--;
                // System.out.println("Size: " + size);

                // System.out.println("Fresh count: "+fresh_count);
                // System.out.println("Queue size: " + q.size());
                // System.out.println("Queue: " + Arrays.deepToString(q.toArray()));
                int[] currentCell = q.poll();
                for (int[] dir : dirs) {
                    int row = currentCell[0] + dir[0];
                    int col = currentCell[1] + dir[1];

                    // System.out.println("Row: " + row);
                    // System.out.println("Col: " + col);
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[] { row, col });
                        fresh_count--;

                    }

                }
            }

        }
        if (fresh_count > 0)
            return -1;
        return count;

    }

    public static void main(String[] args) {

        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        Solution s = new Solution();

        int x = s.orangesRotting(grid);
        System.out.println(x);
        // s.orangesRotting(grid);


        // System.out.println(Arrays.deepToString(grid));

    }
}