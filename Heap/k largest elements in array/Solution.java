import java.util.*;
class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> minHeap =new PriorityQueue<Integer>();
        for(int i =0; i<n; i++){
            minHeap.add(arr[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] ans= new int[k];
        for(int i =k-1; i>=0; i--){
            ans[i]= minHeap.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,23,12,9,30,2,50};
        int n = arr.length;
        int k = 3;
        Solution obj = new Solution();
        int[] ans = obj.kLargest(arr, n, k);
        for(int i =0; i<k; i++){
            System.out.print(ans[i]+" ");
        }
    }
}