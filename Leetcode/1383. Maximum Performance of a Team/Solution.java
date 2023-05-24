import java.util.*;
class Solution {
    public int maxPerformance(int n,int[] speed, int[] efficiency, int k) {
        int pairs[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i] = new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(pairs, (a, b) -> (b[1]-a[1]));
        long res = 0;
        long sum =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int [] pair: pairs){
            pq.add(pair[0]);
            sum += pair[0];
            if(pq.size() > k){
                sum -= pq.poll();
            }
            
            res = Math.max(res, sum*pair[1]);
          
        }
        return (int) (res % (long)(1e9 + 7));


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 6;
        int[] nums1 = {2,10,3,1,5,8};
        int[] nums2 = {5,4,3,9,7,2};
        int k = 3;
        System.out.println(sol.maxPerformance(n, nums1, nums2, k));
    }
}