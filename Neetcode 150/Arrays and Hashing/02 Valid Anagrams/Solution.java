// intution : use array of size 26 to store the frequency of each character in string s and then decrement the frequency of each character in string t and then check if any character has non zero frequency if yes return false else return true.

// An anagram is a word or phrase formed by rearranging the letters of another word or phrase. For example, "listen" and "silent" are anagrams of each other.

// The method works by counting the frequency of each character in the first string s using an integer array called count. It then decrements the frequency of each character in the second string t by iterating through its characters. If the two strings are anagrams, then the frequency of each character in the count array should be zero at the end of the loop.

// Finally, the method checks if any character in the count array has a non-zero frequency. If it does, then the method returns false because the two strings are not anagrams. Otherwise, the method returns true.

// This implementation is efficient because it only needs to iterate through each string once and uses a constant amount of extra space.

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        
        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        Solution sol = new Solution();
        System.out.println(sol.isAnagram(s, t));
    }
}