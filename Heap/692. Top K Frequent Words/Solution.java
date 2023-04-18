import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
            
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
            (w1, w2)-> map.get(w1).equals(map.get(w2))? w2.compareTo(w1):map.get(w1)-map.get(w2)
        );
        for(String word: map.keySet()){
            pq.offer(word);
            if(pq.size()>k){
                pq.remove();
            }
        }
        List<String> ans = new ArrayList<>();
        while(pq.size()!=0){
            ans.add(0, pq.poll());

        }
        
        return ans;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(s.topKFrequent(words, k));
    }
}