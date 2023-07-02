class Solution {
    public int maximumRequests(int n, int[][] requests) {
        // Create an array to store the indegree of each node
        int indegree[] = new int[n];

        // Call the helper function to recursively process the requests
        return helper(0, requests, indegree, 0);
    }

    private int helper(int start, int[][] requests, int[] indegree, int count) {
        // Base case: If we have processed all the requests
        if (start == requests.length) {
            // Check if all nodes have an indegree of 0, indicating a balanced state
            for (int i : indegree) {
                if (i != 0) {
                    return 0;
                }
            }
            return count; // Return the count of balanced requests
        }
        // Update the indegree of the corresponding nodes for the current request
        indegree[requests[start][0]]--;
        indegree[requests[start][1]]++;

        // Recursive call when we choose to take the current request
        int take = helper(start + 1, requests, indegree, count + 1);

        // Reset the indegree changes made for the current request
        indegree[requests[start][0]]++;
        indegree[requests[start][1]]--;

        // Recursive call when we choose not to take the current request
        int nottake = Integer.MIN_VALUE;
        // Check if the source and destination nodes for the current request are different
        if (requests[start][0] != requests[start][1])
            nottake = helper(start + 1, requests, indegree, count);

        // Return the maximum count achieved by taking or not taking the current request
        return Math.max(take, nottake);
    }


    public static void main(String [] args){
        Solution sol = new Solution();
        int [][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        int n = 5;
        System.out.println(sol.maximumRequests(n, requests));
    }
}
