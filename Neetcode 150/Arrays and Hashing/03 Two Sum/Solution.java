//intution: we we use hashmap to store the elements and their indices such that if the trget-nums[i] is present in the map then we return the indices of the target-nums[i] and the current element else we add the element and its index to the map and continue the loop
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        int nums[]={2,7,11,15};
        int target = 9;
        Solution s = new Solution();
        int[] res = s.twoSum(nums, target);
        System.out.println(res[0]+" "+res[1]);

    }

}