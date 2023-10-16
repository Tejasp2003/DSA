class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            // If the length of the input string is less than the target string, no valid window exists.
            return "";
        }
        
        String result = ""; // The minimum window found so far.
        int minLen = Integer.MAX_VALUE; // The minimum length of the window.
        int left = 0; // Left pointer of the window.
        int right = 0; // Right pointer of the window.
        HashMap<Character, Integer> targetCharCount = new HashMap<>(); // Count of characters in the target string.
        int remaining = t.length(); // Number of characters still needed to form a valid window.

        for (char c : t.toCharArray()) {
            // Populate the targetCharCount with the characters from the target string.
            targetCharCount.put(c, targetCharCount.getOrDefault(c, 0) + 1);
        }
        
        while (right < s.length()) {
            if (targetCharCount.containsKey(s.charAt(right))) {
                // Update the count of the character at the right pointer.
                targetCharCount.put(s.charAt(right), targetCharCount.get(s.charAt(right)) - 1);
                if (targetCharCount.get(s.charAt(right)) >= 0) {
                    // If the count is still positive or zero, it means we found a required character.
                    remaining--;
                }
            }
            
            while (remaining == 0) {
                // We found a valid window. Update the minimum window if needed.
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                
                if (targetCharCount.containsKey(s.charAt(left))) {
                    // Move the left pointer and update the character count.
                    targetCharCount.put(s.charAt(left), targetCharCount.get(s.charAt(left)) + 1);
                    if (targetCharCount.get(s.charAt(left)) > 0) {
                        // If the count becomes positive, it means the window is no longer valid.
                        remaining++;
                    }
                }
                left++;
            }
            right++;
        }
        
        return result;
    }
}
