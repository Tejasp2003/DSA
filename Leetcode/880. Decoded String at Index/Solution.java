//intution: here we will first calcualte the size by checking if the character is digit or not, if it's digit then we will multiply the size with the digit and if it's not then we will increase the size by 1. After calculating the size we will start from the end of the string and work backwards. We will reduce K to the position within the current segment. If K becomes 0 and the current character is a letter, return it. If the current character is a letter, reduce the size by 1. If the current character is a digit, adjust the size based on the digit.

public class Solution {
    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        long size = 0; // Initialize the size of the decoded string.

        // Calculate the total size of the decoded string.
        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch)) {
                size *= (ch - '0'); // If it's a digit, adjust the size.
            } else {
                size++; // If it's a letter, increase the size by 1.
            }
        }

        // Start from the end of the string and work backwards.
        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            K %= size; // Reduce K to the position within the current segment.

            // If K becomes 0 and the current character is a letter, return it.
            if (K == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }

            // If the current character is a letter, reduce the size by 1.
            if (Character.isLetter(c)) {
                size--;
            } else {
                // If the current character is a digit, adjust the size based on the digit.
                size = size / (c - '0');
            }
        }

        return "";
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "leet2code3";
        int k = 10;
        System.out.println(sol.decodeAtIndex(s, k));
    }
}
