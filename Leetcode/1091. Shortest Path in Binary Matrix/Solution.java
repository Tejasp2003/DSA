import java.util.*;

class Solution {
    class Pair{
        int first;
        int second;
        int third;
        public  Pair(int first, int second, int third){
            this.first= first;
            this.second=second;
            this.third=third;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> q= new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]!=0) return -1;
        int dist[][]= new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0]=1;
        q.offer(new Pair(1,0,0));
        int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dc = {0, 1, 0, -1, -1, 1, 1, -1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int dis= p.first;
            int r= p.second;
            int c= p.third;
            if(r==n-1 && c==m-1) return dis;
            for(int i =0; i<8; i++){
                int newR= r+ dr[i];
                int newC= c+ dc[i];
                if(newR>=0 && newR<n && newC>=0&& newC<m && grid[newR][newC]==0 && dis+1< dist[newR][newC]){
                    dist[newR][newC]= dis+1;
                    q.offer(new Pair(1+dis, newR, newC));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution sol= new Solution();
        int[][] grid= {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid));
    }
}