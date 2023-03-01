//problem link: https://leetcode.com/problems/number-of-provinces/description/


//here we can get the count of the provinces by using the dfs traversal. As we know, we have the unconnected graph, we can count the number of dfs traversals and then return the count. let for example if have given a graph like 1-2-3 4-5 8-7-9 then we will make the visited array from 1-9 and then we start dfs from by running a for loop from 1 to n(9). The dfs of 1 will mark 1,2,3 as visited and increase the count by 1. Now in for loop, we will run dfs for 2, but as 2 is already visited, we will exit.. similarly for 3. Now for 4, we will check if it's visited or not. Here the 4 will be unvisited and hence we will call dfs from 4, which will mark 4,5,6 visited and increase the count by 1. similarly we will call for dfs from 8 and which will mark 8,7,9 visited and increase the count by 1. Now the count will be 3. This way, we will get the count of the provinces. Hence the time complexity will be O(n^2) and the space complexity will be O(n) as we are using the visited array. And the space complexity of the dfs will be O(n) as we are using the recursion stack. Also, we can use the bfs traversal to solve this problem. The time complexity will be O(n^2) and the space complexity will be O(n) as we are using the visited array. And the space complexity of the bfs will be O(n) as we are using the queue.
import java.util.*;
class Solution {
    public void dfs(int i, boolean [] visited, int[][] isConnected){
        for(int j =0; j<isConnected.length; j++){
            if(isConnected[i][j] ==1 && !visited[j])
            {
                visited[j] = true;
                dfs(j, visited, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean visited [] = new boolean[isConnected.length];
        int count =0;
        for(int i =0; i<isConnected.length; i++){// for every node, we will check if it is visited or not. If it is not visited then we will call the dfs function from that node and increase the count. 
            if(!visited[i])
            {
                dfs(i, visited,isConnected);
                count++;
            }
        }
        return count;
    }
    public static void main(String [] args){
        Solution s = new Solution();
        int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(s.findCircleNum(isConnected));
    }
}