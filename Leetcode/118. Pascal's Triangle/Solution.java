import java.util.ArrayList;
import java.util.List;

class Solution {

    // Generates a single row of Pascal's Triangle based on the given row number
    private static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // The first element of every row is always 1

        // Loop through the columns of the current row
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col); // Calculate the numerator
            ans = ans / col; // Calculate the denominator
            ansRow.add((int) ans); // Add the calculated value to the row
        }

        return ansRow;
    }

    // Generates Pascal's Triangle with the specified number of rows
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through each row up to the specified number of rows
        for (int row = 1; row <= numRows; row++) {
            ans.add(generateRow(row)); // Generate and add each row to the triangle
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generate(5)); // Example usage: Generate Pascal's Triangle with 5 rows
    }
}
