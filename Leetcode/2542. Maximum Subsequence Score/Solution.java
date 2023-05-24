
import java.util.*;
class Solution {
    public int maxPerformance(int n,int[] nums1, int[] nums2, int k) {
        int MOD =(int) 1e9 + 7;
        int pairs[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> (b[1]-a[1]));
        int res = 0;
        int sum =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int [] pair: pairs){
            pq.add(pair[0]);
            sum += pair[0];
            if(pq.size() > k){
                sum -= pq.poll();
            }
            if(pq.size() == k){
                res = Math.max(res, sum*pair[1]);
            }
        }
        return res%MOD;


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