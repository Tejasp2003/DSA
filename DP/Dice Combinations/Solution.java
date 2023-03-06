import java.util.*;

//Problem Statement:
//Here we have to get the total number of ways to make the sum N by throwing a dice. We can throw the dice,as many times as we want

//Example
//Input: N = 3
//Output: 4
//Explanation:
//1+1+1
//1+2
//2+1
//3

//Input: N = 4
//Output: 8
//Explanation:
//1+1+1+1
//1+1+2
//1+2+1
//2+1+1
//2+2
//1+3
//3+1
//4

//Solution 1: Recursive Solution
//Intution:
//We can solve this problem by using recursion. We can throw the dice, as many times as we want. So, we can throw the dice, and then we can throw the dice again, and so on. So, we can use recursion to solve this problem. We can use a variable, to keep track of the sum, and we can use a variable, to keep track of the number of dice thrown. We can use a variable, to keep track of the number of ways to make the sum N by throwing a dice. We can use a base case, to check if the sum is equal to N, and if the number of dice thrown is equal to N. If both the conditions are true, then we can increment the number of ways to make the sum N by throwing a dice. If the sum is greater than N, then we can return. If the number of dice thrown is greater than N, then we can return. If the sum is less than N, then we can throw the dice again, and we can call the function recursively. We can return the number of ways to make the sum N by throwing a dice.

//why pick , nonPick will not work here?
//because we can throw the dice, as many times as we want. So, we can throw the dice, and then we can throw the dice again, and so on. So, we can use recursion to solve this problem.

//Time Complexity: O(6^N)
//Space Complexity: O(N)

// class Solution {
//     static int totalNumberOfWays(int target) {

//         if (target == 0)
//             return 1;
//         if (target < 0)
//             return 0;
//         int count = 0;
//         for (int i = 1; i <= 6; i++) {
//             count += totalNumberOfWays(target - i);
//         }
//         return count;

//     }

//     public static void main(String[] args) {
//         int N = 4;
//         int result = totalNumberOfWays(N);
//         System.out.println(result);
//     }
// }

//Solution 2: Memoization
//Intution:
//We can solve this problem by using memoization. We can use a variable, to keep track of the sum, and we can use a variable, to keep track of the number of dice thrown. We can use a variable, to keep track of the number of ways to make the sum N by throwing a dice. We can use a base case, to check if the sum is equal to N, and if the number of dice thrown is equal to N. If both the conditions are true, then we can increment the number of ways to make the sum N by throwing a dice. If the sum is greater than N, then we can return. If the number of dice thrown is greater than N, then we can return. If the sum is less than N, then we can throw the dice again, and we can call the function recursively. We can return the number of ways to make the sum N by throwing a dice.

//Time Complexity: O(N^2)
//Space Complexity: O(N^2)

// class Solution {
//     static int mod = (int) 1e9 + 7;

//     static int totalNumberOfWays(int target, int[] dp) {

//         if (target == 0)
//             return 1;
//         if (target < 0)
//             return 0;
//         if (dp[target] != -1)
//             return dp[target];
//         int count = 0;
//         for (int i = 1; i <= 6; i++) {
//             count = (count + totalNumberOfWays(target - i, dp)) % mod;
//         }
//         return dp[target] = count;

//     }

//     public static void main(String[] args) {
//         int N;
//         Scanner sc = new Scanner(System.in);
//         N = sc.nextInt();
//         sc.close();

//         int[] dp = new int[N + 1];

//         Arrays.fill(dp, -1);
//         int result = totalNumberOfWays(N, dp);
//         System.out.println(result);
//     }
// }

//Solution 3: Tabulation
//Intution:
//We can solve this problem by using tabulation. We can use a variable, to keep track of the sum, and we can use a variable, to keep track of the number of dice thrown. We can use a variable, to keep track of the number of ways to make the sum N by throwing a dice. We can use a base case, to check if the sum is equal to N, and if the number of dice thrown is equal to N. If both the conditions are true, then we can increment the number of ways to make the sum N by throwing a dice. If the sum is greater than N, then we can return. If the number of dice thrown is greater than N, then we can return. If the sum is less than N, then we can throw the dice again, and we can call the function recursively. We can return the number of ways to make the sum N by throwing a dice.

//Time Complexity: O(N^2)
//Space Complexity: O(N)

class Solution{
    static int mod = (int)1e9+7;
    static int totalNumberOfWays(int N){
        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int target = 1; target<=N; target++){
            for(int dice = 1; dice<=6; dice++){
                if(target-dice>=0){
                    dp[target] = (dp[target] + dp[target-dice])%mod;
                }
            }

        }

        return dp[N];
    }
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
        int result = totalNumberOfWays(N);
        System.out.println(result);
    }

}


