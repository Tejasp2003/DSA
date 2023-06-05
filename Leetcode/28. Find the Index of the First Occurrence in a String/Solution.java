class Solution {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m= needle.length();
        int i=0; int j=0;
         
                while(j<m && i<n && haystack.charAt(i)==needle.charAt(j)){
                    i++;
                    j++;
                }
                if(j==m){
                    return i-m;
                }
                else{
                    j=0;
                }
            
            i++;

        
        return -1;

    }
    public static void main(String [] args){
        String haystack = "sadbusted";
        String needle = "st";
        System.out.println(strStr(haystack, needle));
        
    }
}