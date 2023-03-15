//pronblem link: https://leetcode.com/problems/perfect-squares/

//intution:
//we can use the same approach as we used in coin change problem
//we will try to find the minimum number of perfect squares that sum up to the target
//we will store the squares less than the target number into an array, and the apply coin change problem
// import java.util.*;
// class Solution {

//     private int solve(int index, int target, int[] squaresArray){
//         if(target==0){
//             return 0;
//         }
//         if(index==squaresArray.length){
//             return (int) Math.pow(10, 9);
//         }
//         int take = (int) Math.pow(10, 9);
//         if(squaresArray[index]<=target){
//             take = 1+solve(index, target-squaresArray[index], squaresArray);
//         }
//         int notTake = solve(index+1, target, squaresArray);
//         return Math.min(take, notTake);
//     }
//     public int numSquares(int target) {
//         ArrayList<Integer>squares= new ArrayList<>();
//         for(int i =1; i*i<target; i++){
//             squares.add(i*i);
//         }

//         //convert list to array
//         int[] squaresArray = squares.stream().mapToInt(i->i).toArray();

//         return solve(0,target, squaresArray);
        
        
//     }
//     public static void main(String[] args) {
//         Solution s = new Solution();
//         System.out.println(s.numSquares(12));
//     }

// }


// ........................................Another Solution.......................................................\\

//Solution 1: Simple Recusrion


// class Solution {

//     private int solve(int n){
//         if(n==0) return 0;
//         int ans = n;
//         for(int i =1; i*i<=n; i++){
//             int temp = i*i;
//             ans = Math.min(ans, 1+ solve(n - temp));
//         }
//         return ans;
//     }
//     public int numSquares(int n) {
//         return solve(n);
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         System.out.println(s.numSquares(12));

//     }
// }

//Solution 2: Memoization


//Time Complexity: O(n*sqrt(n))
//Space Complexity: O(n)
import java.util.*;
// class Solution {

//     private int solve(int n, int[] dp){
//         if(n==0) return 0;
//         int ans = n;
//         if(dp[n]!=-1) return dp[n];
//         for(int i =1; i*i<=n; i++){
//             int temp = i*i;
//             ans = Math.min(ans, 1+ solve(n - temp, dp));
//         }
//         return dp[n]=ans;
//     }
//     public int numSquares(int n) {
//         int[]dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return solve(n, dp);
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         System.out.println(s.numSquares(12));

//     }
// }


//Solution 3: Bottom Up Approach

//Time Complexity: O(n*sqrt(n))
//Space Complexity: O(n)

class Solution {

    public int numSquares(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp, (int)Math.pow(10, 9));
        dp[0]=0;
        
        for(int target=1; target<=n; target++){
            for(int i =1; i*i<=n; i++){
                int temp = i*i;
                if(target-temp>=0)dp[target] = Math.min(dp[target], 1+ dp[target-temp]);
            }
             
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(12));

    }
}