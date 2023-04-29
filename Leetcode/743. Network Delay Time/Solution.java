import java.util.*;

class Solution {
    class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // creating adj list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        // filling adj list
        int m = times.length;
        for (int i = 0; i < m; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new Pair(v, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.weight - y.weight);
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new Pair(k, 0));
        while (pq.size() != 0) {
            Pair it = pq.poll();
            int node = it.node;
            int weight = it.weight;
            for (Pair i : adj.get(node)) {
                if (weight + i.weight < dist[i.node]) {
                    dist[i.node] = weight + i.weight;
                    pq.offer(new Pair(i.node, dist[i.node]));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(sol.networkDelayTime(times, 4, 2));
    }
}
