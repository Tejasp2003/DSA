import java.util.*;
class Solution {
    public int[][] kClosest(int[][] points, int k) {
         PriorityQueue<int[]> maxHeap= new PriorityQueue<>((p1, p2)->Integer.compare((p2[0]*p2[0]+p2[1]*p2[1]),(p1[0] * p1[0] + p1[1] * p1[1])));
        for(int i =0; i<points.length; i++){
            maxHeap.offer(points[i]);
            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }
        int ans[][]= new int[k][2];
        while(k>0){
            ans[--k]=maxHeap.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        System.out.println(Arrays.deepToString(s.kClosest(points, k)));
    }
}