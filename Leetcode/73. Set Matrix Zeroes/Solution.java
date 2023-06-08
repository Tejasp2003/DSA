// class Solution {

    // Time: O(n*m)
    // Space: O(n+m)
    //better approach
    // public void setZeroes(int[][] matrix) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int markRow[] = new int[n];
    //     int markCol[] = new int[m];

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] ==0){
    //                 markRow[i]=1;
    //                 markCol[j]=1;
    //             }
    //         }
    //     }
    //      for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(markRow[i]==1||
    //                 markCol[j]==1){
    //                 matrix[i][j]=0;
    //             }
    //         }
    //     }

        
    //}

    //optimal approach

    //intution :
    //we will use first row and first column as a marker
    //if any element in matrix is zero then we will mark its first row and first column as zero
    //then we will traverse the matrix again and if we find any element as zero then we will mark its first row and first column as zero 

import java.util.Arrays;



class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false; // Flag to mark if the first row should be set to zeroes
        boolean fc = false; // Flag to mark if the first column should be set to zeroes
        int n = matrix.length;
        int m = matrix[0].length;

        // Step 1: Mark the first row and first column if an element is zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true; // If the first row has a zero, mark the flag
                    if (j == 0) fc = true; // If the first column has a zero, mark the flag
                    matrix[0][j] = 0; // Mark the first element of the column as zero
                    matrix[i][0] = 0; // Mark the first element of the row as zero
                }
            }
        }

        // Step 2: Set zeroes based on the marked first row and first column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0; // Set the element to zero if the corresponding first row or column is zero
                }
            }
        }

        // Step 3: Set zeroes for the first row
        if (fr) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0; // Set all elements in the first row to zero
            }
        }

        // Step 4: Set zeroes for the first column
        if (fc) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0; // Set all elements in the first column to zero
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int matrix[][] = {{1, 1, 1},
                          {1, 0, 1},
                          {1, 1, 1}};

        s.setZeroes(matrix);

        Arrays.stream(matrix).forEach(a -> System.out.println(Arrays.toString(a)));
    }
}

    


