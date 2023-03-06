class Solution {
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