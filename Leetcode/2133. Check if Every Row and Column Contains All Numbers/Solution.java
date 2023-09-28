
import java.util.HashSet;
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (!rowSet.add(matrix[row][col]))
                    return false;
                if (!colSet.add(matrix[col][row]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };
        System.out.println(sol.checkValid(matrix));
    }
}

