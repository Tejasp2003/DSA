//dijikstra

import java.util.*;
// class Solution {
//     class Pair {
//         int x;
//         int y;
//         int weight;
//         public Pair(int x, int y, int weight){
//             this.x = x;
//             this.y = y;
//             this.weight = weight;
//         }
//     }
    
//     public int swimInWater(int[][] grid) {
//         PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Integer.compare(x.weight, y.weight));
//         int n = grid.length;
//         boolean visited[][]= new boolean[n][n];
//         pq.offer(new Pair(0, 0, grid[0][0]));
//         int dx[] = {0, 0, 1, -1};
//         int dy[] = {1, -1, 0, 0};
//         while(pq.size() != 0){
//             Pair it= pq.poll();
//             int x= it.x;
//             int y= it.y;
//             int weight= it.weight;
//             if(x == n-1 && y == n-1){
//                 return weight;
//             }
//             if(visited[x][y]){
//                 continue;
//             }
//             for(int i = 0; i < 4; i++){
//                 int newR = x + dx[i];
//                 int newC = y + dy[i];
//                 if(newR >= 0 && newR < n && newC >= 0 && newC < n && !visited[newR][newC]){
//                     pq.offer(new Pair(newR, newC, Math.max(weight, grid[newR][newC])));
//                 }
//             }
//             visited[x][y] = true;
//         }
//         return -1;
//     }
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int grid[][] = {{0,2},{1,3}};
//         System.out.println(sol.swimInWater(grid));
//     }
// }

//binary search+ dfs

class Solution {
    class Pair {
        int x;
        int y;
        int weight;
        public Pair(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n*n-1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(canReach(grid, mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    
    private boolean canReach(int[][] grid, int maxWeight) {
        int n = grid.length;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        Queue<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        if(grid[0][0] <= maxWeight) {
            queue.offer(new Pair(0, 0, grid[0][0]));
            visited[0][0] = true;
        }
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            if(curr.x == n-1 && curr.y == n-1) {
                return true;
            }
            for(int i = 0; i < 4; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] <= maxWeight) {
                    queue.offer(new Pair(newX, newY, grid[newX][newY]));
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int grid[][] = {{0,2},{1,3}};
        System.out.println(sol.swimInWater(grid));
    }
}
