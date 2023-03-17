import java.util.*;

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create an array to store the indegree of each node
        int indegree[]= new int[V];
        
        // Iterate through the adjacency list to count the indegree of each node
        for(int i =0; i<V; i++){
            for(int node: adj.get(i)){
                indegree[node]++;
            }
        }
        
        // Create a queue to store nodes with 0 indegree
        Queue<Integer> q= new LinkedList<>();
        
        // Add nodes with 0 indegree to the queue
        for(int i =0; i<V; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        // Create an array to store the topological order of the nodes
        int i =0 ;
        int topo[]= new int[V];
        
        // Perform topological sort
        while(!q.isEmpty()){
            // Get the node with 0 indegree and remove it from the queue
            int node= q.peek();
            q.remove();
            
            // Add the node to the topological order array
            topo[i++] = node;
            
            // Iterate through the adjacent nodes of the current node and reduce their indegree by 1
            for(int adjNode: adj.get(node)){
                indegree[adjNode]--;
                // If the indegree of an adjacent node becomes 0, add it to the queue
                if(indegree[adjNode]==0){
                    q.offer(adjNode);
                }
            }
        }
        
        // Return the topological order array
        return topo.length==V? false: true;
    
    }

    public static void main(String[] args) {
        int V = 4; // Number of nodes in the graph
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // Add edges to the graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        Solution obj = new Solution();
        System.out.println(obj.isCyclic(V, adj));
    }
}