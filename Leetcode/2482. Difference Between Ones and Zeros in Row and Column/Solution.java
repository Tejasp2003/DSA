class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        System.out.println("m: "+ m + " n: " + n);
        int[] rows = new int[m];
        int[] cols =  new int[n];
        int diff[][]= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                rows[i]+=grid[i][j];
                cols[j]+=grid[i][j];
            }
            System.out.println("rows["+ i + "]: "+rows[i]);
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                diff[i][j]= rows[i]+cols[j]-(n-rows[i])-(m-cols[j]);
            }
        }
        return diff;
    }
    public static void main(String[] args){
        int[][] grid = {{1,0,0,0,1},{0,1,0,1,0},{0,0,1,0,0}};
        Solution sol = new Solution();
        int[][] diff = sol.onesMinusZeros(grid);
        for(int i=0; i<diff.length; i++){
            for(int j=0; j<diff[0].length; j++){
                System.out.print(diff[i][j]+" ");
            }
            System.out.println();
        }
    }
}

// class Solution {
//     public int[][] onesMinusZeros(int[][] grid) {
//         int m= grid.length;
//         int n = grid[0].length;
//         System.out.println("m: "+ m + " n: " + n);
//         int[] rows = new int[m];
//         int[] cols =  new int[n];
//         int diff[][]= new int[m][n];
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 int offset = 2* grid[i][j]-1; // if 1 the 2(1)-1 = 1 and if 0 then 0-1=-1.. hence we will get the difference stored directly
//                 rows[i]+=offset;
//                 cols[j]+=offset;
//             }
            
//         }
        
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 diff[i][j]= rows[i]+cols[j];
//             }
//         }
//         return diff;
//     }
// }