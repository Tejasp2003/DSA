import java.util.*;
class Solution {
    
    // shortestPath function takes in edges (array of edges between nodes),
    // n (number of nodes), m (number of edges), and src (source node)
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges to the adjacency list
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        // Initialize an array to store the distances from source node to all other nodes
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            // Set the initial distance to a very large value (1e9 here)
            dist[i] = (int)1e9;
        }
        
        // Set the distance of the source node to 0
        dist[src] = 0;
        
        // Create a queue to implement BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        
        // Run BFS to compute the shortest distance from source node to all other nodes
        while (!q.isEmpty()) {
            // Get the next node in the queue
            int node = q.peek();
            q.remove();
            
            // Check all adjacent nodes and update their distances if a shorter path is found
            for (int adjNode : adj.get(node)) {
                if (dist[adjNode] > dist[node] + 1) {
                    dist[adjNode] = 1 + dist[node];
                    q.offer(adjNode);
                }
            }
        }
        
        // Replace all large distances with -1 to indicate that there is no path to that node
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1; 
            }
        }
        
        // Return the array of distances
        return dist; 
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 5}};
        int[] dist = s.shortestPath(edges, 6, 9, 0);
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance from node 0 to node " + i + " is " + dist[i]);
        }
    }
}
