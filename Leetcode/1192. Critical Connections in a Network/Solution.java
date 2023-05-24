import java.util.*;
class Solution {

    public void dfs(int node, int parent, List[] graph, boolean[] visited, int[] dt, int[] low, int time, List<List<Integer>> ans){
        visited[node]=true;
        dt[node]=low[node]=time++;
        for(int child: (List<Integer>)graph[node]){
            if(child==parent)continue;
            if(!visited[child]){
                dfs(child,node,graph,visited,dt,low,time,ans);
                low[node]=Math.min(low[node],low[child]);
                if(dt[node]<low[child]){
                    ans.add(Arrays.asList(node,child));
                }
            }
            else{
                low[node]=Math.min(low[node],dt[child]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(List<Integer> connection: connections){
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }   
        List<List<Integer>> ans = new ArrayList<>();
        int dt[] = new int[n];
        int low[] = new int[n];
        int time =0;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,-1,graph,visited,dt,low,time, ans);
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int n=4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));


        System.out.println(s.criticalConnections(n,connections));
       

    }
}