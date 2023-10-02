import java.util.*;

class Solution {
    public boolean winnerOfGame(String s) {
        int count=0;
        for(int i =1; i<s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i-1) && s.charAt(i)==s.charAt(i+1)){
                if(s.charAt(i)=='A'){
                    count++;
                }
                else{
                    count--;
                }
            }
        }
        return count>0;
        
    }
    public static void main(String[] args){
        String s = "AAABABB";
        Solution obj = new Solution();
        System.out.println(obj.winnerOfGame(s));
    }
}