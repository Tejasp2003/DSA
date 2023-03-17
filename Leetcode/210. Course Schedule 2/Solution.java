
import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // Create an adjacency list to represent the courses and their dependencies
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list with the dependencies of each course
        for(int i = 0; i< prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        // Create an array to keep track of the indegree of each course (number of incoming edges)
        int[] indegree = new int[numCourses];
        for(int i = 0; i< numCourses; i++){
            for(int node: adj.get(i)){
                indegree[node]++;
            }
        }

        // Create a queue to store courses with no dependencies
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        // Create an array to store the topological order of courses
        int topo[]= new int[numCourses];
        int i = 0;
        
        // Use a breadth-first search to traverse the graph and find the topological order
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            for(int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }
        
        // If the number of nodes processed is less than the number of courses, there must be a cycle in the graph
        if(i < numCourses) {
            return new int[0];
        }
        
        return topo;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        Solution s = new Solution();
        int[] result = s.findOrder(numCourses, prerequisites);
        for(int i = 0; i< result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
