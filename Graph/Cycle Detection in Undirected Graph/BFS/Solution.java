// detect cycle in an undirected graph

//Intution:
// We can use BFS to detect cycles in an undirected graph. We start at a node and perform a BFS.
// If we encounter a node that has already been visited, we check if it visited node is the parent of the current node or not
// If it is not the parent of the current node, then there is a cycle in the graph.


// Time Complexity: O(V+E)
// Space Complexity: O(V)

import java.util.*;

class Solution {
    // This function performs a BFS to check for cycles starting at the given source node
    public boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean []vis ){
        vis[src]= true; // mark the source node as visited
        Queue<int[]> q= new LinkedList<>(); // create a queue to store the nodes to be visited
        q.offer(new int[]{src, -1}); // add the source node to the queue along with its parent (-1 means no parent)
        while(!q.isEmpty()){ // while there are still nodes in the queue
            int node = q.peek()[0]; // get the next node to visit from the front of the queue
            int parent = q.peek()[1]; // get the parent of the next node to visit
            q.remove(); // remove the next node to visit from the queue
            for(int adjNode: adj.get(node)){ // for each adjacent node of the current node
                if(!vis[adjNode]){ // if the adjacent node has not been visited
                    vis[adjNode] = true; // mark the adjacent node as visited
                    q.offer(new int[] {adjNode, node}); // add the adjacent node to the queue along with its parent
                }
                else if(parent != adjNode){ // if the adjacent node has been visited and it is not the parent of the current node
                    return true; // there is a cycle, so return true
                }
            }         
        }
        return false; // there is no cycle, so return false
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V]; // create a boolean array to store the visited nodes
        for(int i=0; i<V; i++){ // for each node in the graph
            if(!vis[i]) { // if the node has not been visited
                if(checkForCycle(i, V,adj, vis)) // check for cycles starting at the node
                    return true; // if there is a cycle, return true
            }
        }
        return false; // if there are no cycles, return false
    }

    public static void main(String[] args) {
        
        // create a graph
        int V = 5;
        int[][] adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} ;
        //Array to ArrayList
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<Integer>());
            for(int j=0; j<adj[i].length; j++){
                adjList.get(i).add(adj[i][j]);
            }
        }

        Solution obj = new Solution();
        System.out.println(obj.isCycle(V, adjList));




    }    

}
