class Solution {
    // This private method checks if all values in the 'count' array are zero.
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) { // Loop through all the 26 characters (a to z)
            if (count[i] != 0) return false; // If any character count is not zero, return false
        }
        return true; // If all counts are zero, return true
    }

    // This public method checks if s1 is a permutation of any substring of s2.
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(); // Length of the first string s1
        int len2 = s2.length(); // Length of the second string s2

        if (len1 > len2) return false; // If s1 is longer than s2, it's impossible for s1 to be a permutation of any substring of s2.

        int count[] = new int[26]; // An array to store the count of each character (a to z) in s1.

        // Count the characters in s1 and populate the 'count' array.
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++; // Increment the count for the character in s1
        }

        // Loop through s2 to check for permutations of s1.
        for (int i = 0; i < len2; i++) {
            count[s2.charAt(i) - 'a']--; // Decrement the count for the character in s2
            if (i - len1 >= 0) {
                count[s2.charAt(i - len1) - 'a']++; // If the window size exceeds len1, increment the count for the character that is no longer in the window
            }
            if (allZero(count)) return true; // If the 'count' array is all zeros, s1 is a permutation of a substring in s2.
        }
        return false; // If no permutation is found, return false.
    }
    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution sol = new Solution();
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("Is s1 a permutation of a substring of s2? " + sol.checkInclusion(s1, s2));
        
    }
}
