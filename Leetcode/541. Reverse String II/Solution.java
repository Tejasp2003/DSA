class Solution {

    private void rev(char[] ch, int i, int j){
        j = Math.min(ch.length, j)-1;
        while(i<j){
            char temp = ch[i];
            ch[i]= ch[j];
            ch[j]= temp;
            i++;
            j--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i+=2*k){
            rev(ch, i, i+k);
        }
        return String.valueOf(ch);
    }
}
