// intution: The method uses two arrays to keep track of the last index of each character in the string and whether each character has been seen before. It then uses a stack to keep track of the unique characters in the string while maintaining their relative order.

// The method iterates through the characters in the string and checks if the current character has already been seen. If it has, the method skips to the next character. If it hasn't, the method checks if the current character is smaller than the character at the top of the stack and occurs after it in the string. If it is, the method pops the character from the stack and marks it as unseen. This process continues until the stack is empty or the character at the top of the stack is smaller than the current character.

// After the loop completes, the method constructs a string from the characters in the stack in reverse order and returns it.


import java.util.*;
class Solution {
    public String removeDuplicateLetters(String s) {
        int [] lastIndex = new int[26];
        for(int i=0; i<s.length(); i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        boolean[] seen = new boolean[26];
        Stack<Integer> st = new Stack();
        for(int i=0; i<s.length(); i++){
            int curr = s.charAt(i)-'a';
            if(seen[curr]) continue;
            while(!st.isEmpty() && st.peek()>curr && i<lastIndex[st.peek()]){ // check if curr elemet is msaller than the elemr at top of stack and element at top of stack is occuring after also
                seen[st.pop()]= false; //pop element and mark it false in seen array
            }
            st.push(curr);
            seen[curr] = true;

        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char) (st.pop() + 'a'));

        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "cbacdcbc";
        System.out.println(sol.removeDuplicateLetters(s));
    }
}