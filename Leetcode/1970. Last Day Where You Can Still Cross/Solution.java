import java.util.*;

class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // 'directions' array defines the possible directions to move: down, up, right, left
    // Each direction is represented by a pair of (row, column) increments

    public boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        // 'grid' represents the state of the cells in the grid
        // 0: empty cell, 1: cell with an obstacle, -1: visited cell
        // Initially, all cells are empty (0)

        Queue<int[]> queue = new LinkedList<>();
        // 'queue' is used for breadth-first search (BFS) traversal of the grid

        // Mark cells with obstacles as 1 in the grid
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            // cells[i] contains the coordinates (row, col) of an obstacle
            // Subtract 1 to convert 1-based indexing to 0-based indexing
            // Mark the corresponding cell as an obstacle (1) in the grid
        }

        // Initialize the queue with the cells in the first row that are not obstacles
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                // Add the cell coordinates (row, col) to the queue
                // Mark the cell as visited (-1) in the grid
                grid[0][i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            // Retrieve the coordinates (row, col) of the current cell

            if (r == row - 1) {
                return true;
                // If the current cell is in the last row, return true
                // This means we have successfully crossed to the last row
            }

            // Explore all possible directions from the current cell
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                // Calculate the new coordinates after moving in a direction

                // Check if the new coordinates are within the grid boundaries and the cell is empty
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = -1;
                    // Mark the new cell as visited (-1) in the grid
                    queue.offer(new int[]{newRow, newCol});
                    // Add the new cell to the queue for further exploration
                }
            }
        }

        return false;
        // If we exhaust all possible cells to explore and cannot reach the last row, return false
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = row * col;
        // 'left' represents the minimum possible day to cross (initially 1)
        // 'right' represents the maximum possible day to cross (initially the total number of cells)

        while (left < right) {
            int mid = right - (right - left) / 2;
            // Calculate the middle day between left and right
            // This allows us to perform binary search for the latest day to cross

            if (canCross(row, col, cells, mid)) {
                left = mid;
                // If it is possible to cross on or before the middle day, update the left bound
                // This means we can search for a later day to cross
            } else {
                right = mid - 1;
                // If it is not possible to cross on or before the middle day, update the right bound
                // This means we need to search for an earlier day to cross
            }
        }

        return left;
        // When left and right converge, we have found the latest day to cross
        // Return left, which represents the latest possible day to cross
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int row = 2;
        int col = 2;
        int[][] cells = new int[][]{{1,1},{2,1},{1,2},{2,2}};
        System.out.println(sol.latestDayToCross(row, col, cells));
    }
}
