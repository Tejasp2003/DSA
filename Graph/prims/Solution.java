import java.util.*;
class Solution{
    class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
	public int spanningTree(int V, int E, int edges[][]){
	    int m = edges.length;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int from = edge[0];
            int to = edge[1];
            int wt = edge[2];
            graph.get(from).add(new Pair(to, wt));
            graph.get(to).add(new Pair(from, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair(0, 0));
        boolean visited[] = new boolean[V];
        int dist=0;
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            int node = rem.node;
            int distance = rem.distance;
            if (visited[node])
                continue;
            visited[node] = true;
            dist+=distance;
            for (Pair nbr : graph.get(node)) {
                int nbrNode = nbr.node;
                int nbrDistance = nbr.distance;
                if (!visited[nbrNode]) {
                    pq.add(new Pair(nbrNode, nbrDistance));
                }
            }
        }
        return dist;

	}
    public static void main(String[] args) {
        int V = 5;
        int E = 7;
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 3, 6 },
                { 1, 3, 8 },
                { 1, 2, 3 },
                { 1, 4, 5 },
                { 2, 4, 7 },
                { 3, 4, 9 }
        };
        Solution s = new Solution();
        System.out.println(s.spanningTree(V, E, edges));
    }
}