
import java.util.*;
class Solution {
    // Helper function to perform topological sort using DFS
    private void topoSort(int node, ArrayList<ArrayList<int[]>> adj, int[] visited,
        Stack<Integer> st)
    {
        visited[node] = 1; // Mark the current node as visited

        // Visit all adjacent nodes that are not yet visited
        for (int i = 0; i < adj.get(node).size(); i++) {
            int[] adjNode = adj.get(node).get(i); // Get the adjacent node and weight
            int adjNodeId = adjNode[0];
            int weight = adjNode[1];
            if (visited[adjNodeId] == 0) {
                topoSort(adjNodeId, adj, visited, st); // Recursively perform topological sort
            }
        }

        st.add(node); // Add the current node to the stack
    }

    public int[] shortestPath(int numNodes, int numEdges, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>(); // Adjacency list representation of the graph
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<int[]>());
        }

        // Add the edges to the adjacency list
        for (int i = 0; i < numEdges; i++) {
            int startNode = edges[i][0];
            int endNode = edges[i][1];
            int weight = edges[i][2];
            adj.get(startNode).add(new int[]{endNode, weight});
        }

        int[] visited = new int[numNodes]; // Array to keep track of visited nodes
        Stack<Integer> st = new Stack<>(); // Stack to store nodes in the order of topological sort

        // Perform topological sort on all unvisited nodes
        for (int i = 0; i < numNodes; i++) {
            if (visited[i] == 0) {
                topoSort(i, adj, visited, st);
            }
        }

        int[] dist = new int[numNodes]; // Array to keep track of shortest distances from source node (node 0)
        Arrays.fill(dist, Integer.MAX_VALUE); // Set initial distances to maximum value
        dist[0] = 0; // Distance to source node is 0

        // Process nodes in the order of topological sort
        while (!st.isEmpty()) {
            int node = st.peek(); // Get the next node from the stack
            st.pop();

            // Update the distances to all adjacent nodes if a shorter path is found through the current node
            for (int i = 0; i < adj.get(node).size(); i++) {
                int[] adjNode = adj.get(node).get(i); // Get the adjacent node and weight
                int adjNodeId = adjNode[0];
                int weight = adjNode[1];
                if (dist[node] + weight < dist[adjNodeId]) {
                    dist[adjNodeId] = dist[node] + weight;
                }
            }
        }

        // Convert unreachable nodes to -1 (as required by the problem statement)
        for (int i = 0; i < numNodes; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist; // Return the array of shortest distances
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges= {{0,1,1},{0,2,4},{1,2,2},{1,3,7},{1,4,3},{2,3,5},{3,4,1}};
        int[] dist = s.shortestPath(5, 7, edges);
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        }

    }
}
