import java.util.*;
class Solution {
    static void dfs(char[][] board, int row, int col){
        // Get the dimensions of the board
        int m = board.length;
        int n = board[0].length;
        
        // Define the possible directions to move from a cell
        int [][] dirs ={{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        // If the current cell is a valid 'O', mark it with '+'
        if(row>=0 && row<m && col>=0 && col<n && board[row][col]=='O'){
            board[row][col]= '+';
            
            // Recursively check all neighboring cells for 'O'
            for(int []dir: dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                dfs(board, newRow, newCol);
            }
        }
    }
    
    static char[][] fill(int p, int q, char board[][]) {
        // Check if the board is empty or null
        if(board.length==0 || board == null) return board;
        
        // Get the dimensions of the board
        int m = board.length;
        int n = board[0].length;

        // Traverse the first and last column to find 'O's on the edges
        for(int row =0; row<m; row++){
            if(board[row][0]== 'O')
            {
                // Perform DFS to mark all connected 'O's with '+'
               dfs(board, row, 0);
            }
            if(board[row][n-1]=='O'){
                dfs(board, row, n-1);
            }
        }
        
        // Traverse the first and last row to find 'O's on the edges
        for(int col =0; col<n; col++){
            if(board[0][col]=='O'){
               dfs(board, 0, col);
            }
            if(board[m-1][col]=='O'){
                dfs(board, m-1, col);
            }
        }
        
        // Traverse the board again and mark remaining 'O's as 'X' and '+' as 'O'
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                else if(board[i][j]== '+')
                {
                    board[i][j]= 'O';
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] board ={{'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'X', 'O', 'O'}};

        Solution s= new Solution();
        char[][] result = s.fill(5, 4, board);
        System.out.println(Arrays.deepToString(result));
    }
}
