import java.util.*;

class Pair{
    int node;
    double weight;
    public Pair(int node, double weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // creating adj list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        // filling adj list
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> (int)(y.weight - x.weight));
        double dist[] = new double[n+1];
        Arrays.fill(dist, 0);
        dist[start] = 1;
        pq.offer(new Pair(start, 1));
        while(pq.size()!=0){
            Pair it= pq.poll();
            int node = it.node;
            double  weight= it.weight;
            for(Pair i: adj.get(node)){
                if(weight*i.weight>dist[i.node]){
                    dist[i.node]= weight*i.weight;
                    pq.offer(new Pair(i.node, dist[i.node]));
                }
            }
        }
        return dist[end];
 
    }
    public static void main(String[] args) {
        Solution sol= new Solution();
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        System.out.println(sol.maxProbability(n, edges, succProb, 0, 2));
    }
}