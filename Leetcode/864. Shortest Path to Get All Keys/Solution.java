import java.util.*;
class Solution {
    // Inner class to represent the state of the search algorithm
    class State {
        int keys;  // Bitmask representing the keys collected so far
        int row;   // Current row position
        int col;   // Current column position
        
        // Constructor to initialize the State object
        State(int keys, int row, int col) {
            this.keys = keys;
            this.row = row;
            this.col = col;
        }
    }
    
    // Main method to find the shortest path to collect all keys
    public int shortestPathAllKeys(String[] grid) {
        int startX = -1, startY = -1;  // Starting position
        int rows = grid.length;        // Number of rows in the grid
        int cols = grid[0].length();   // Number of columns in the grid
        int totalKeys = 0;             // Total number of keys in the grid
        
        // Find the starting position and count the total number of keys
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char c = grid[row].charAt(col);
                if (c == '@') {
                    startX = row;
                    startY = col;
                }
                if (c >= 'a' && c <= 'f') {
                    totalKeys++;
                }
            }
        }
        
        // Create the initial state with no keys collected at the starting position
        State start = new State(0, startX, startY);
        Queue<State> q = new LinkedList<>();  // Queue for breadth-first search
        Set<String> visited = new HashSet<>();  // Set to store visited states
        visited.add(0 + " " + startX + " " + startY);  // Mark the starting state as visited
        q.offer(start);  // Enqueue the starting state
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // Directions: right, down, left, up
        int step = 0;  // Variable to keep track of the number of steps taken
        
        // Breadth-first search loop
        while (!q.isEmpty()) {
            int size = q.size();
            
            // Process all states at the current level
            while (size-- > 0) {
                State curr = q.poll();  // Dequeue the current state
                
                // If all keys have been collected, return the number of steps taken
                if (curr.keys == (1 << totalKeys) - 1) {
                    return step;
                }
                
                // Explore all possible directions
                for (int[] dir : dirs) {
                    int newR = curr.row + dir[0];
                    int newC = curr.col + dir[1];
                    int keys = curr.keys;
                    
                    // Check if the new position is within the grid boundaries
                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
                        char c = grid[newR].charAt(newC);
                        
                        // If the new position is a wall, skip it
                        if (c == '#') {
                            continue;
                        }
                        
                        // If the new position contains a key, update the keys bitmask
                        if (c >= 'a' && c <= 'f') {
                            keys |= 1 << (c - 'a');
                        }
                        
                        // If the new position contains a locked door and the key is not collected, skip it
                        if (c >= 'A' && c <= 'F' && ((1 << (c - 'A')) & keys) == 0) {
                            continue;
                        }
                        
                        // If the state has not been visited, mark it as visited and enqueue it
                        if (!visited.contains(keys + " " + newR + " " + newC)) {
                            visited.add(keys + " " + newR + " " + newC);
                            q.offer(new State(keys, newR, newC));
                        }
                    }
                }
            }
            
            step++;  // Increment the step count
        }
        
        return -1;  // If all keys cannot be collected, return -1
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] grid = {"@.a.#","###.#","b.A.B"};
        System.out.println("grid: " + Arrays.toString(grid));
        System.out.println("shortestPathAllKeys: " + sol.shortestPathAllKeys(grid));
    }
}
