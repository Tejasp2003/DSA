import java.util.*;
class Solution{
    class Pair{
        int src;
        int dest;
        Pair(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void dfs(int src,int parent,ArrayList<Pair>[] graph,boolean visited[],int dt[],int low[],int time){
        visited[src]=true;
        dt[src]=low[src]=time++;
        for(Pair p: graph[src]){
            if(!visited[p.dest]){
                dfs(p.dest,src,graph,visited,dt,low,time);
                low[src]=Math.min(low[src],low[p.dest]);
                if(low[p.dest]>dt[src]){
                    System.out.println(src+"->"+p.dest+" is a bridge");
                }
            }
            else if(p.dest!=parent){
                low[src]=Math.min(low[src],dt[p.dest]);
            }
        }
    }
    public static void tarjan(int n, ArrayList<Pair>[] graph){
        int dt[] = new int[n];
        int low[] = new int[n];
        int time =0;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,-1,graph,visited,dt,low,time);
            }
        }



    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n=6;
        ArrayList<Pair> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(s.new Pair(0,1));
        graph[0].add(s.new Pair(0,2));
        graph[1].add(s.new Pair(1,0));
        graph[1].add(s.new Pair(1,2));
        graph[2].add(s.new Pair(2,0));
        graph[2].add(s.new Pair(2,1));
        graph[2].add(s.new Pair(2,3));
        graph[3].add(s.new Pair(3,2));
        graph[3].add(s.new Pair(3,4));
        graph[3].add(s.new Pair(3,5));
        graph[4].add(s.new Pair(4,3));
        graph[4].add(s.new Pair(4,5));
        graph[5].add(s.new Pair(5,3));
        graph[5].add(s.new Pair(5,4));

        
        //print the graph for learning purpose
        for(int i=0;i<n;i++){
            System.out.print(i+"->");
            for(Pair p: graph[i]){
                System.out.print(p.dest+" ");
            }
            System.out.println();
        }
        s.tarjan(n, graph);
    }
    
}