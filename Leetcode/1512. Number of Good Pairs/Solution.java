
import java.util.HashMap;
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        for(int i: nums){
            int numCount=map.getOrDefault(i, 0);
            count+=numCount;
            map.put(i, numCount+1);
        
        }
        return count;

    }
    public static void main(String[] args){
        int[] nums = {1,2,3,1,1,3};
        Solution obj = new Solution();
        int ans = obj.numIdenticalPairs(nums);
        System.out.println(ans);
    }
}