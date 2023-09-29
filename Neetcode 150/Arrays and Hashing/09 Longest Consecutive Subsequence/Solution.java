// intution: Store all elements in set.. then look for element which is the start of sequence.. if the element has no previous element then it is the start of sequence.. then look for the next element in the sequence.. if the next element is present in the set then increment the count.. else return the count.. and update the max count..
import java.util.HashSet;
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int longest=0;
        for(int n: set){
            if(!set.contains(n-1)){
                int m = n+1;
                while(set.contains(m)){
                    m++;
                }
                longest = Math.max(longest, m-n);
            }

        }
        return longest;
    }
    public static void main(String[] args){
        int[] nums = {100,2,4,6,101,102,8,6,103};
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(nums));

    }
}