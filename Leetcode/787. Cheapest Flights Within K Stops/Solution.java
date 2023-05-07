import java.util.ArrayList;

class Solution {
    class Pair {
        int v;
        int w;
        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            graph.get(u).add(new Pair(v, w));
        }
        int dist[] = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for(int i = 0; i <= k; i++){
            int temp[] = new int[n];
            for(int j = 0; j < n; j++){
                temp[j] = dist[j];
            }
            for(int u = 0; u < n; u++){
                for(Pair it: graph.get(u)){
                    int v = it.v;
                    int w = it.w;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]){
                        temp[v] = dist[u] + w;
                    }
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}