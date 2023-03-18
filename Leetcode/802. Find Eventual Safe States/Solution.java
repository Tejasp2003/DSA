//problem link: https://leetcode.com/problems/find-eventual-safe-states/
import java.util.*;
// class Solution {
//     // Helper method to perform depth-first search on the graph
//     private boolean dfs(int node, int[][] graph, int[] check, int[] visited, int[] pathVisited) {
//         visited[node] = 1; // Mark the current node as visited
//         pathVisited[node] = 1; // Mark the current node as visited in the current path
        
//         check[node] = 0; // Mark the current node as unsafe
        
//         // Traverse all the adjacent nodes
//         for (int adjNode : graph[node]) {
//             if (visited[adjNode] == 0) { // If the adjacent node has not been visited
//                 // Recursively perform dfs on the adjacent node
//                 if (dfs(adjNode, graph, check, visited, pathVisited)) {
//                     return true; // If a cycle is found, return true
//                 }
//             } else if (pathVisited[adjNode] == 1) { // If the adjacent node has been visited in the current path
//                 return true; // A cycle is found, return true
//             }
//         }
        
//         check[node] = 1; // If no cycle is found, mark the current node as safe
//         pathVisited[node] = 0; // Mark the current node as unvisited in the current path
        
//         return false; // Return false if no cycle is found
//     }
    
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int V = graph.length; // Number of nodes in the graph
        
//         int visited[] = new int[V]; // Array to store whether a node has been visited
//         int pathVisited[] = new int[V]; // Array to store whether a node has been visited in the current path
//         int check[] = new int[V]; // Array to store whether a node is safe or not
        
//         for (int i = 0; i < V; i++) { // Traverse all the nodes in the graph
//             if (visited[i] == 0) { // If the node has not been visited
//                 dfs(i, graph, check, visited, pathVisited); // Perform dfs on the node
//             }
//         }
        
//         List<Integer> safeNodes = new ArrayList<>(); // List to store the safe nodes
        
//         for (int i = 0; i < V; i++) { // Traverse all the nodes in the graph
//             if (check[i] == 1) { // If the node is safe
//                 safeNodes.add(i); // Add the node to the list of safe nodes
//             }
//         }
        
//         return safeNodes; // Return the list of safe nodes
//     }

//     public static void main(String[] args) {
//         int[][] graph={
//             {1,2},
//             {2,3},
//             {5},
//             {0},
//             {5},
//             {},
//             {}
//         };
//         Solution s = new Solution();
//         System.out.println(s.eventualSafeNodes(graph));
//     }
// }


//solution 2: using topo sort




class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>(); // Initialize the list to hold the eventual safe nodes
        int[] indegree = new int[n]; // Initialize an array to hold the indegree of each node
        List<List<Integer>> adj = new ArrayList<>(); // Initialize an adjacency list to represent the reverse of the input graph
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build the adjacency list and calculate the indegree of each node
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i); // Add i to the list of neighbors of node in the reverse graph
            }
            indegree[i] = graph[i].length; // Calculate the indegree of node i
        }
        Queue<Integer> q = new LinkedList<>();
        // Add all nodes with indegree 0 to the queue to start the topological sort
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        // Perform the topological sort
        while (!q.isEmpty()) {
            int node = q.peek(); // Get a node with indegree 0 from the queue
            q.remove(); // Remove the node from the queue
            ans.add(node); // Add the node to the result list
            for (int adjNode : adj.get(node)) { // Iterate through the neighbors of the current node in the reverse graph
                indegree[adjNode]--; // Decrement the indegree of each neighbor
                if (indegree[adjNode] == 0) { // If the neighbor's indegree becomes 0, add it to the queue
                    q.offer(adjNode);
                }
            }
        }
        Collections.sort(ans); // Sort the result list
        return ans; // Return the list of eventual safe nodes
    }

    public static void main(String[] args) {
        int[][] graph={
            {1,2},
            {2,3},
            {5},
            {0},
            {5},
            {},
            {}
        };
        Solution s = new Solution();
        System.out.println(s.eventualSafeNodes(graph));
    
}
}


