import java.util.*;

class Solution {
    // Pair class to represent source and destination vertices
    class Pair {
        int src;
        int dest;
        
        Pair(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private static void dfs(int curr, int parent, ArrayList<Pair> graph[], boolean[] visited, int[] dt, int[] low, int time) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        
        // Traverse through all adjacent vertices of the current vertex
        for (Pair p : graph[curr]) {
            if (!visited[p.dest]) {
                // Recursively call dfs on the adjacent vertex
                dfs(p.dest, curr, graph, visited, dt, low, time);
                
                // Update the low value of the current vertex
                low[curr] = Math.min(low[curr], low[p.dest]);
                
                // Check if the current vertex is an articulation point
                if (parent != -1 && dt[curr] <= low[p.dest]) {
                    System.out.println("AP: " + curr);
                }
                
                children++;
            } else if (visited[p.dest]) {
                // Update the low value of the current vertex if it has been visited
                low[curr] = Math.min(low[curr], dt[p.dest]);
            }
        }
        
        // Check if the root vertex is an articulation point
        if (parent == -1 && children > 1) {
            System.out.println("AP: " + curr);
        }
    }

    public static void getArticulationPoint(ArrayList<Pair> graph[], int v) {
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        boolean[] visited = new boolean[v];
        
        // Iterate through all vertices and perform DFS
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, -1, graph, visited, dt, low, time);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 6;
        ArrayList<Pair> graph[] = new ArrayList[n];
        
        // Initialize adjacency list for each vertex
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Define the graph connections
        graph[0].add(s.new Pair(0, 1));
        graph[0].add(s.new Pair(0, 2));
        graph[1].add(s.new Pair(1, 0));
        graph[1].add(s.new Pair(1, 2));
        graph[2].add(s.new Pair(2, 0));
        graph[2].add(s.new Pair(2, 1));
        graph[2].add(s.new Pair(2, 3));
        graph[3].add(s.new Pair(3, 2));
        graph[3].add(s.new Pair(3, 4));
        graph[3].add(s.new Pair(3, 5));
        graph[4].add(s.new Pair(4, 3));
        graph[4].add(s.new Pair(4, 5));
        graph[5].add(s.new Pair(5, 3));
        graph[5].add(s.new Pair(5, 4));

        // Call the function to find articulation points
        getArticulationPoint(graph, n);
    }
}
