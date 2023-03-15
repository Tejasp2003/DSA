import java.util.*;

class Solution {
    // DFS function to traverse the graph and add nodes to stack
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int[] visited) {
        visited[node] = 1; // Mark current node as visited
        for (int adjNode : adj.get(node)) { // Traverse through all adjacent nodes
            if (visited[adjNode] == 0) { // If adjacent node is not visited, perform DFS on it
                dfs(adjNode, adj, st, visited);
            }
        }
        st.push(node); // Push current node to stack once all its adjacent nodes are visited
    }

    // Topological sort function
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V]; // Array to keep track of visited nodes
        Stack<Integer> st = new Stack<>(); // Stack to store nodes in topological order

        // Perform DFS on all nodes in the graph
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, st, visited);
            }
        }

        int[] ans = new int[V]; // Array to store the final topological order
        int i = 0;
        // Pop nodes from stack and add them to the answer array in reverse order
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }

        return ans; // Return the topological order of the graph
    }

    public static void main(String[] args) {
        int V = 6; // Number of nodes in the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // Adjacency list to store the graph
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);

        int[] ans = topoSort(V, adj); // Perform topological sort on the graph

        // Print the topological order

        System.out.println(Arrays.toString(ans));

    }
}
