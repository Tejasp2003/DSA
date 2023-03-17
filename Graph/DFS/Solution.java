//problem link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
import java.util.*;
class Solution {
    
    public static void dfs(int node, boolean[] visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]= true;
        ans.add(node);
        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(i, visited, ans, adj);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[V];
        visited[0] = true;
        dfs(0, visited, ans, adj);
        return ans;
        
    }

    public static void main(String [] args){
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        adj.add(l1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0);
        adj.add(l2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(0);
        adj.add(l3);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(0);
        adj.add(l4);
        System.out.println(s.dfsOfGraph(4, adj));
    }
}