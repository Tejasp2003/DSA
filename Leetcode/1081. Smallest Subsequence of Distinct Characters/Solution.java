


import java.util.*;
class Solution {
    public String smallestSubsequence(String s) {
        int lastIndex[] = new int[26];
        for(int i=0; i<s.length(); i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        boolean[] seen = new boolean[26];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            int curr = s.charAt(i)-'a';
            if(seen[curr]) continue;
            while(!st.isEmpty() && st.peek()> curr && i<lastIndex[st.peek()]){
                seen[st.pop()]= false;
            }
            seen[curr]=true;
            st.push(curr);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char) (st.pop()+'a'));
        }
        return sb.reverse().toString();
     
        
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "cbacdcbc";
        System.out.println(sol.smallestSubsequence(s));
    }
}