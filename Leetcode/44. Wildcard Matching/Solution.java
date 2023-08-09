// class Solution {
//     private boolean helper(int i, int j, String s, String p, boolean[][] dp){
//         if(dp[i][j]) return dp[i][j];
//         boolean ans;
//         if(j==p.length()){
//             ans= i==s.length();
//         }
//         else if(i==s.length()){
//            ans= (p.charAt(j)=='*' && helper(i, j+1, s, p, dp));
//         }
//         else{
//            boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'));


//             if(p.charAt(j)=='*'){
//                 ans= (helper(i, j+1, s,p, dp) || helper(i+1, j, s, p, dp));
//             }
//             else{
//                 ans= (firstMatch &&  helper(i+1, j+1, s, p, dp));
//             }
//         }

        
       
//         dp[i][j] = ans;
//         return ans;
//     }
// }

class Solution {
    public boolean isMatch(String s, String p) {
        
        boolean [][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for( int i=1; i<=p.length(); i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=true;
            }
            else{
                break;
            }
        }

        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length(); j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]= dp[i-1][j] || dp[i][j-1];
                }
                else if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

