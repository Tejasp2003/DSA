import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create a queue to store the current word and the number of steps taken to reach it
        Queue<String[]> q = new LinkedList<>(); 
        
        // add the starting word to the queue with a step count of 1
        q.offer(new String[]{beginWord, "1"}); 
        
        // create a set to store the remaining words in the wordList
        Set<String> st = new HashSet<>();
        for (String word : wordList) {
            st.add(word);
        }
        
        // remove the starting word from the set, since it has already been used
        st.remove(beginWord);
        
        while (!q.isEmpty()) {
            // get the current word and the number of steps taken to reach it from the queue
            String[] curr = q.poll();
            String word = curr[0];
            int count = Integer.parseInt(curr[1]);
            
            // if we have reached the target word, return the number of steps taken to reach it
            if (word.equals(endWord)) return count;
            
            // generate all possible words by replacing each letter in the current word with all letters from a to z
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedArray = word.toCharArray();
                    replacedArray[i] = ch;
                    String newWord = String.valueOf(replacedArray);
                    
                    // if the new word is in the remaining word list, remove it from the list and add it to the queue with a step count of one more than the current word
                    if (st.contains(newWord)) {
                        st.remove(newWord);
                        q.offer(new String[]{newWord, Integer.toString(count + 1)});
                    }
                }
            }
        }
        
        // if we cannot reach the target word, return 0
        return 0;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(s.ladderLength(beginWord, endWord, Arrays.asList("hot","dot","dog","lot","log","cog")));
        




        

    }
}
