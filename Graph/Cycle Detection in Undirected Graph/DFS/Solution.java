//Detect cycle in an undirected graph using dfs

//Intution:
// We can use DFS to detect cycles in an undirected graph. We start at a node and perform a DFS.
// If we encounter a node that has already been visited, we check if it visited node is the parent of the current node or not
// If it is not the parent of the current node, then there is a cycle in the graph.

// Time Complexity: O(V+E)
// Space Complexity: O(V)

import java.util.*;

class Solution{

    // helper function to perform DFS
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int curr, int parent){
        visited[curr] = true; // mark current node as visited
        for(int next: adj.get(curr)){ // iterate through neighbors of current node
            if(!visited[next]){ // if neighbor is not visited
                if(dfs(adj, visited, next, curr)){ // perform dfs on unvisited neighbor
                    return true; // if cycle found, return true
                }
            }
            else if(next != parent){ // if neighbor is already visited and not a parent, cycle exists
                return true; // return true
            }
        }
        return false; // no cycle found
    }

    // main function to check for cycle
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V]; // array to mark visited nodes
        for (int i = 0; i < V; i++) { // iterate through each node in the graph
            if (!visited[i]) { // if node is not visited
                if (dfs(adj, visited, i, -1)) { // perform DFS on the node and check for cycle
                    return true; // if cycle found, return true
                }
            }
        }
        return false; // no cycle found
    }

    public static void main(String[] args) {
            
        // create a graph
        int V = 5;
        int[][] adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} ;
        // convert 2D array to ArrayList
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<Integer>());
            for(int j = 0; j < adj[i].length; j++){
                adjList.get(i).add(adj[i][j]);
            }
        }
        Solution s = new Solution();
        System.out.println(s.isCycle(V, adjList));
    }
}
