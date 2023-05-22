class Solution {
    public int balancedStringSplit(String s) {
        int rcount=0;
        int splits=0;
       for(char c: s.toCharArray()){
           if(c=='R')rcount++;
           else rcount--;
           if(rcount==0)splits++;
       }
    return splits;
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.balancedStringSplit("RLRRLLRLRL"));
    }
}