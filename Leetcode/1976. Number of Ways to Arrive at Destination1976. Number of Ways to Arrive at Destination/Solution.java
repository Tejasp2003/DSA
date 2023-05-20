
import java.util.*;

class Solution {
    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int mod = (int) Math.pow(10, 9) + 7;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int road[] : roads) {
            int from = road[0];
            int to = road[1];
            int time = road[2];
            graph.get(from).add(new Pair(to, time));
            graph.get(to).add(new Pair(from, time));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(0, 0));
        int time[] = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = 0;
        int ways[] = new int[n];
        ways[0] = 1;

        while (pq.size() > 0) {
            Pair rem = pq.remove();
            int node = rem.node;
            int t = rem.time;
            if (t > time[node])
                continue;

            for (Pair nbr : graph.get(node)) {
                int nbrNode = nbr.node;
                int nbrTime = nbr.time;
                if (t + nbrTime < time[nbrNode]) {
                    time[nbrNode] = t + nbrTime;
                    pq.add(new Pair(nbrNode, time[nbrNode]));
                    ways[nbrNode] = ways[node];
                } else if (t + nbrTime == time[nbrNode]) {
                    ways[nbrNode] = (ways[nbrNode] + ways[node]) % mod;

                }
            }

        }
        return ways[n - 1];

    }

    public static void main(String[] args) {
        int n = 7;

        int[][] roads = {
                { 0, 6, 7 },
                { 0, 1, 2 },
                { 1, 2, 3 },
                { 1, 3, 3 },
                { 6, 3, 3 },
                { 3, 5, 1 },
                { 6, 5, 1 },
                { 2, 5, 1 },
                { 0, 4, 5 },
                { 4, 6, 2 }
        };

        Solution s = new Solution();
        System.out.println(s.countPaths(n, roads));

    }
}