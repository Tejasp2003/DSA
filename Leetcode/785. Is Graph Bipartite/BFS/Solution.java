//problem link: https://leetcode.com/problems/is-graph-bipartite/

//intution: 
//here we will color the nodes of graph with two colors 1 and -1
//if we find a node which is not colored yet, we will color it with 1 and then we will color its adjacent nodes with -1
//if we find a node which is already colored, we will check if its color is same as the color of its adjacent node
//if yes, then we will return false
//if no, then we will color its adjacent node with the opposite color of its color
//we will repeat this process until we have colored all the nodes of the graph
//if we are able to color all the nodes of the graph, then we will return true

import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i =0; i<n; i++){
            if(color[i]==0){//if not colored yet
                Queue<Integer> q= new LinkedList<>();//add the node to the queue
                q.offer(i);
                color[i]=1;//color the node with 1
                while(!q.isEmpty()){
                    int currNode = q.poll();//remove the node from the queue
                    for(int adjNode: graph[currNode]){//getting the adjacent nodes of the current node
                        if(color[adjNode]==0){//if not colored yet
                            color[adjNode]=-color[currNode];//color it with the opposite color of its parent
                            q.offer(adjNode);//add it to the queue
                        }
                        else if(color[adjNode]!= -color[currNode]){//if already colored, check if its color is same as the color of its parent
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(s.isBipartite(graph));
    }
}