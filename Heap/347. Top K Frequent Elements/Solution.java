
import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Integer> pq= new PriorityQueue((i, j)-> map.get(i)-map.get(j));
        for(int i : map.keySet()){
            pq.offer(i);
            if(pq.size()>k){
                pq.remove();
            }
        }
        int ans[]= new int[k];
        for(int i=k-1; i>=0; i--){
            ans[i]= pq.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(s.topKFrequent(nums, k)));
    }
}