//problem link: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

import java.util.*;
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[V];//visited array to store information about whther the node is visited or not.
        Queue<Integer> q = new LinkedList<>();//queue to store the elements that are remained to traverse.
        q.add(0);//add first element to the queue
        visited[0] = true; //mark the first element visited in the visited array
        while(!q.isEmpty()){ // run a while loop, untill no elemnt left in the queue to traverse
            int node = q.poll(); //q.poll will return the head of the queue
            ans.add(node);
            for(int i: adj.get(node)){ // here for each node, we will look for the childern of the node in the adjacnecy list. adj.get(node) will get the all the children of the selected node
                if(visited[i] == false){
                    visited[i] = true;
                    q.add(i);
                    
                }
            }
        }
        return ans;
    }


    public static void main(String [] args){
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        adj.add(l1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0);
        adj.add(l2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(0);
        adj.add(l3);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(0);
        adj.add(l4);
        System.out.println(s.bfsOfGraph(4, adj));
    }
}