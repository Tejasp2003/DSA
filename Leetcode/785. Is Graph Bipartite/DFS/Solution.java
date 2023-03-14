import java.util.ArrayList;
class Solution {

    // This is a helper method that performs a depth-first search on the graph.
    // It colors the nodes of the graph such that no two adjacent nodes have the same color.
    // If it encounters a node that has already been colored, it checks that the color matches the expected color.
    // Returns true if the coloring is possible, false otherwise.
    private boolean dfs(int i, int []colors, int[][] graph, int color){
        // If the node has not been colored yet, color it with the given color.
        if(colors[i]==0){
            colors[i]=color;
            // Recursively color all the adjacent nodes with the opposite color.
            for(int adjNode: graph[i]){
                if(!dfs(adjNode, colors,graph, -color )){
                    // If any of the adjacent nodes cannot be colored, return false.
                    return false;
                }
            }
        }
        else {
            // If the node has already been colored, check that the color matches the expected color.
            return colors[i]==color;
        }
        // If the node has been successfully colored and all its adjacent nodes can also be colored,
        // return true.
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int []colors = new int[n];
        // Iterate over all the nodes in the graph.
        for(int i =0; i<n ; i++){
            // If the node has not been colored yet, start a new depth-first search from that node.
            if(colors[i]==0 && !dfs(i, colors, graph, 1))
            {
                // If the graph cannot be colored, return false.
                return false;
            }
        }
        // If the graph can be colored, return true.
        return true;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(s.isBipartite(graph));
    }

}