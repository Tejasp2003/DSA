import java.util.*;

public class Solution {
    public int equalPairs(int[][] grid) {
        int res = 0; // Initialize the result variable
        int n = grid.length; // Get the length of the grid
        HashMap<String, Integer> x = new HashMap<>(); // Create a HashMap to store the string representations and their counts
        
        // Loop over each row in the grid
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            // Loop over each element in the row
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]); // Append the current element to the StringBuilder
                sb.append(','); // Append a comma separator
            }
            
            String curr = sb.toString(); // Convert the StringBuilder to a string
            x.put(curr, x.getOrDefault(curr, 0) + 1); // Add the string representation to the HashMap and increment its count
        }
        
        // Loop over each column in the grid
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            // Loop over each element in the column
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]); // Append the current element to the StringBuilder
                sb.append(','); // Append a comma separator
            }
            
            String curr = sb.toString(); // Convert the StringBuilder to a string
            if (x.containsKey(curr)) // Check if the string representation exists in the HashMap
                res += x.get(curr); // Add the count of the string representation to the result
        }
        
        return res; // Return the final result
    
}

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(sol.equalPairs(grid));
    }
}