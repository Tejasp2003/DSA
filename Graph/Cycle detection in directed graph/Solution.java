import java.util.*;
class Solution {
    
    private boolean dfs(int node,ArrayList<ArrayList<Integer>> adj, int[] visited, int[]pathVisited){
        visited[node]=1;
        pathVisited[node]=1;
        for(int adjNode: adj.get(node)){
            if(visited[adjNode]==0){
                if(dfs(adjNode, adj, visited, pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[adjNode]==1){
                return true;
            }
            
        }
        pathVisited[node]= 0;
        return false;
    }
  
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[]= new int[V];
        int pathVisited[]= new int[V];
        for(int i =0; i<V; i++){
            if(visited[i]==0){
                if(dfs(i, adj, visited, pathVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i =0; i<V; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        System.out.println(s.isCyclic(V, adj));
    }
}