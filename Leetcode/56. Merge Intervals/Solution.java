
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        List<int[]> result= new ArrayList<>();
        int [] newInterval= intervals[0];
                result.add(newInterval);

        
        // System.out.println(Arrays.deepToString(result.toArray()));
      
        for(int[] interval: intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]=Math.max(newInterval[1], interval[1]);
                // System.out.println(Arrays.deepToString(result.toArray()));
            }
            else{
                newInterval= interval;
                result.add(newInterval);
                // System.out.println(Arrays.deepToString(result.toArray()));
            }
        }
        		return result.toArray(new int[result.size()][]);

   }
   public static void main(String [] args){
    int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
    Solution s = new Solution();
    System.out.println(Arrays.deepToString(s.merge(intervals)));

   }
}