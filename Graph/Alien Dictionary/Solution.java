import java.util.*;
class Solution
{
    private List<Integer> topoSort(int V, List<List<Integer>> adj){
        int indegree[]= new int[V];
        for(int i =0; i<V; i++){
            for(int node: adj.get(i)){
                indegree[node]++;
            }
            
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i =0; i<V; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int i =0; 
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(node);
            for(int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    q.offer(adjNode);
                }
            }
        }
        return ans;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0; i<N-1; i++){
            String s1 = dict[i];
            String s2= dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr =0; ptr<len; ptr++){
                if(s1.charAt(ptr)!=s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }
        List<Integer> topo= topoSort(K, adj);
        String ans = "";
        for(int node: topo){
            ans= ans+ (char)(node+ (int)'a');
        }
        return ans;
        
        
    }

    public static void main(String[] args) {
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        int N = dict.length;
        int K = 4;
        Solution s = new Solution();
        System.out.println(s.findOrder(dict, N, K));
        
    }
}