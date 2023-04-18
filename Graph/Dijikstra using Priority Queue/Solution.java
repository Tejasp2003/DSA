import java.util.*;
class Pair{
    int distance;
    int node;
    public Pair(int distance, int node){
        this.node= node;
        this.distance= distance;
    }
}
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> minHeap= new PriorityQueue<Pair>((x,y)-> x.distance-y.distance);
        int [] distance = new int[V];
        for(int i =0; i<V; i++){
            distance[i]= (int)1e9;
            
        }
        distance[S]=0;
        minHeap.add(new Pair(0, S));
        while(minHeap.size()!=0){
            int dist = minHeap.peek().distance;
            int node = minHeap.peek().node;
            minHeap.remove();
            for(int i =0; i<adj.get(node).size(); i++){
                int edgeWeight= adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(distance[adjNode]> edgeWeight+ dist){
                    distance[adjNode] = edgeWeight+ dist;
                    minHeap.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance;
        
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<ArrayList<Integer>>());
        adj.get(0).add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<Integer>(Arrays.asList(3, 3)));
        adj.get(1).add(new ArrayList<Integer>(Arrays.asList(2, 1)));
        adj.get(2).add(new ArrayList<Integer>(Arrays.asList(3, 1)));
        adj.get(2).add(new ArrayList<Integer>(Arrays.asList(4, 4)));
        adj.get(2).add(new ArrayList<Integer>(Arrays.asList(0, 3)));
        adj.get(3).add(new ArrayList<Integer>(Arrays.asList(4, 2)));
        adj.get(3).add(new ArrayList<Integer>(Arrays.asList(1, 1)));
        adj.get(3).add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        adj.get(4).add(new ArrayList<Integer>(Arrays.asList(3, 2)));
        adj.get(4).add(new ArrayList<Integer>(Arrays.asList(2, 2)));
        int S = 0;
        int[] res = dijkstra(V, adj, S);
        for (int i = 0; i < V; i++)
            System.out.print(res[i] + " ");
    }
}