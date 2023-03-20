import java.util.*;

class Solution
{
    // This function returns the topological sort of the graph
    private List<Integer> topoSort(int V, List<List<Integer>> adj){
        // Create an array to store the indegree of each node
        int indegree[]= new int[V];
        // Calculate the indegree of each node
        for(int i =0; i<V; i++){
            for(int node: adj.get(i)){
                indegree[node]++;
            }
        }
        // Create a queue to store the nodes with indegree 0
        Queue<Integer> q= new LinkedList<>();
        for(int i =0; i<V; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        // Create a list to store the topological sort
        List<Integer> ans = new ArrayList<>();
        int i =0; 
        // Process the nodes in the queue
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(node);
            // Decrease the indegree of the adjacent nodes
            for(int adjNode: adj.get(node)){
                indegree[adjNode]--;
                // If the indegree of the adjacent node becomes 0, add it to the queue
                if(indegree[adjNode]==0){
                    q.offer(adjNode);
                }
            }
        }
        // Return the topological sort
        return ans;
    }
    // This function returns the lexicographically smallest order of the words in the dictionary
    public String findOrder(String [] dict, int N, int K)
    {
        // Create an adjacency list to store the graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<>());
        }
        // Create the graph
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
        // Get the topological sort of the graph
        List<Integer> topo= topoSort(K, adj);
        // Create a string to store the lexicographically smallest order of the words in the dictionary
        String ans = "";
        for(int node: topo){
            ans= ans+ (char)(node+ (int)'a');
        }
        // Return the lexicographically smallest order of the words in the dictionary
        return ans;
    }

    public static void main(String[] args) {
        // Create a dictionary of words
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        int N = dict.length;
        int K = 4;
        // Create an object of the Solution class
        Solution s = new Solution();
        // Find the lexicographically smallest order of the words in the dictionary
        System.out.println(s.findOrder(dict, N, K));
    }
}