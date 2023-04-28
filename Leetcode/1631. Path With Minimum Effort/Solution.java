import java.util.*;
class Solution {
   
    class Pair{
         int distance;
         int row;
         int col;
         public Pair(int distance, int row, int col){
             this.distance= distance;
             this.row= row;
             this.col= col;
         }
     }
     public int minimumEffortPath(int[][] heights) {
         PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y) ->  x.distance- y.distance);
         int n = heights.length;
         int m = heights[0].length;
         int minDist[][]= new int[n][m];
         for(int row[]:minDist){
             Arrays.fill(row, Integer.MAX_VALUE);
         }
         int dr[] = {-1,0,1,0};
         int dc[] = {0,1,0,-1};
         minDist[0][0]=0;
         pq.offer(new Pair(0,0,0));
         while(pq.size()!=0){
             Pair it= pq.poll();
             int diff= it.distance;
             int row= it.row;
             int col= it.col;
             if(row==n-1 && col==m-1) return diff;
             for(int i =0; i<4; i++){
                 int newR= dr[i]+row;
                 int newC= dc[i]+ col;
                 if(newR>=0 && newR<n && newC>=0 && newC<m)
                 {
                     int newEffort = Math.max(diff, Math.abs(heights[row][col]-heights[newR][newC]));
                     if(newEffort<minDist[newR][newC]){
                         minDist[newR][newC]= newEffort;
                         pq.offer(new Pair(newEffort, newR, newC));
                     }
                 }
 
             }
 
         }
 
     return 0;
 
     }
     public static void main(String[] args) {
            Solution sol= new Solution();
            int[][] heights= {{1,2,2},{3,8,2},{5,3,5}};
            System.out.println(sol.minimumEffortPath(heights));
     }
 }