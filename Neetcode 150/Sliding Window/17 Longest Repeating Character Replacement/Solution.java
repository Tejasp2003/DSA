/**
 * This algorithm addresses the problem of finding the maximum length of a substring in the given input string 's' where at most 'k' character replacements are allowed. It leverages a sliding window approach for an efficient solution. The code maintains a window, defined by 'windowStart' and 'windowEnd,' which continuously tracks character counts within the window and adapts its position based on the maximum character count and the replacement constraint. 'maxLength' is updated whenever a longer valid substring is found, ensuring that the code determines the length of the longest substring achievable with a limited number of character replacements.
 */

class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length(); // Get the length of the input string.
        int charCount[] = new int[26]; // Create an array to store the count of each character in the alphabet.
        int windowStart = 0; // Initialize the start of the sliding window.
        int maxLength = 0; // Initialize the maximum substring length with character replacements.
        int maxCharCount = 0; // Initialize the maximum character count in the current window.

        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            // Update the count of the current character in the window.
            charCount[s.charAt(windowEnd) - 'A']++;

            // Update the maximum character count in the current window.
            maxCharCount = Math.max(maxCharCount, charCount[s.charAt(windowEnd) - 'A']);

            int windowSize = windowEnd - windowStart + 1; // Calculate the length of the current window.

            // Check if we need to shrink the window to meet the k replacements constraint.
            while (windowSize - maxCharCount > k) {
                // Update the count for the character at the start of the window.
                charCount[s.charAt(windowStart) - 'A']--;
                // Move the window's start to the right.
                windowStart++;
                windowSize = windowEnd - windowStart + 1; // Recalculate the window size.
            }

            // Update the maximum length of the substring.
            maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength; // Return the maximum substring length with at most k character replacements.
    }
}
