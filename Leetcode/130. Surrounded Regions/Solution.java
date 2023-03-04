import java.util.*;



// BFS Solution
//intution
//As we know if any O is on edge then it can't be comverted to X and also all the O that are connected to the O on edge can also not be concerted into X. Hence we wil do bfs from O on the edges
//1. get all Os on the edge of the board and add them to queue
//2. do bfs from all the Os on the edge and mark all the Os that are connected to the edge Os as +.
//3. after bfs, check if any inner Os are remaining. If yes, convert them to X. If not, convert all + to O


// class Solution {
//     public void solve(char[][] board) {
//         if(board.length==0 || board == null) return;
//         int m = board.length;
//         int n = board[0].length;
//         Queue<int[]> q= new LinkedList<>();
//         int [][] dirs ={{0,1}, {0,-1}, {1,0}, {-1,0}};

//         //getting Os on the edge 
//         for(int row =0; row<m; row++){
//             if(board[row][0]== 'O')
//             {
//                 board[row][0] = '+';
//                 q.offer(new int[]{row, 0});
//             }
//             if(board[row][n-1]=='O'){
//                 board[row][n-1]= '+';
//                 q.offer(new int[] {row, n-1});
//             }

//         }
        
//         for(int col =0; col<n; col++){
//             if(board[0][col]=='O'){
//                 board[0][col]='+';
//                 q.offer(new int[] {0, col});
//             }
//             if(board[m-1][col]=='O'){
//                 board[m-1][col]= '+';
//                 q.offer(new int[]{m-1, col});
//             }
//         }
//         while(!q.isEmpty()){
//             int []currentCell = q.poll();
//             for(int []dir: dirs){
//                 int row = currentCell[0]+dir[0];
//                 int col = currentCell[1]+dir[1];
//                 if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='O'){
//                     board[row][col]= '+';
//                     q.offer(new int[]{row, col});
//                 }
//             }
//         }//after placing + inplace of Os on edge
//         for(int i =0; i<m; i++){
//             for(int j =0; j<n; j++){
//                 if(board[i][j]=='O')//check if any inner O remaining. If yes, convert it into X
//                 {
//                     board[i][j]='X';
//                 }
//                 else if(board[i][j]== '+')//convert + into O again
//                 {
//                     board[i][j]= 'O';
//                 }
//             }
//         }
       
       
//     }
//     public static void main(String args[]){
//         char[][] board = {
//             {'X', 'X', 'X', 'X'},
//             {'X', 'O', 'O', 'X'},
//             {'X', 'X', 'O', 'X'},
//             {'X', 'O', 'X', 'X'}
            

           
//         };

//         Solution s= new Solution();
//         s.solve(board);
//         System.out.println(Arrays.deepToString(board));
//     }

    
// }



//DFS Solution
//intution
//As we know if any O is on edge then it can't be comverted to X and also all the O that are connected to the O on edge can also not be concerted into X. Hence we wil do dfs from O on the edges
//1. get all Os on the edge of the board and add them to stack
//2. do dfs from all the Os on the edge and mark all the Os that are connected to the edge Os as +.
//3. after dfs, check if any inner Os are remaining. If yes, convert them to X. If not, convert all + to O


class Solution {
    private void dfs(char[][] board, int row, int col){
        int m = board.length;
        int n = board[0].length;
        int [][] dirs ={{0,1}, {0,-1}, {1,0}, {-1,0}};
           if(row>=0&&row<m&&col>=0&col<n&&board[row][col]=='O'){
               board[row][col]= '+';
               for(int []dir: dirs){
                   int newRow = row+ dir[0];
                   int newCol = col+dir[1];
                   dfs(board, newRow,newCol);
               }
           }
       }
    public void solve(char[][] board) {
        if(board.length==0 || board == null) return;
        int m = board.length;
        int n = board[0].length;
        // Queue<int[]> q= new LinkedList<>();
        

        //getting Os on the edge 
        for(int row =0; row<m; row++){
            if(board[row][0]== 'O')
            {
               dfs(board, row, 0);
            }
            if(board[row][n-1]=='O'){
                dfs(board, row, n-1);
            }

        }
        
        for(int col =0; col<n; col++){
            if(board[0][col]=='O'){
               dfs(board, 0, col);
            }
            if(board[m-1][col]=='O'){
                dfs(board, m-1, col);
            }
        }
       //after placing + inplace of Os on edge
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(board[i][j]=='O')//check if any inner O remaining. If yes, convert it into X
                {
                    board[i][j]='X';
                }
                else if(board[i][j]== '+')//convert + into O again
                {
                    board[i][j]= 'O';
                }
            }
        }
       
       
    }

    public static void main(String[] args) {
        char[][] board = {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}
                        
            
                       
                    };
            
                    Solution s= new Solution();
                    s.solve(board);
                    System.out.println(Arrays.deepToString(board));
        
    }

}
