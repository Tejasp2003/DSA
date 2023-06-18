import java.util.*;

class Solution{

    private int solve(int[] arr1, int[] arr2, int cur, int prev, int count){
        if(cur==arr1.length){
            return count;
        }
        Arrays.sort(arr2);
        int result1 = Integer.MAX_VALUE;
        int result2 = Integer.MAX_VALUE;
        if(arr1[cur]>prev){
            result1 = solve(arr1, arr2, cur+1, arr1[cur], count);
        }
        int index = Arrays.binarySearch(arr2, prev);
        if(index<0){
            index = -(index+1);
        }
        if(index<arr2.length){
            result2 = solve(arr1, arr2, cur+1, arr2[index], count+1);
        }
        return Math.min(result1, result2);
        

       

    }
     public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        return solve(arr1, arr2, 0, -1, 0);
     }

     public static void main(String[] args) {
         Solution sol = new Solution();
         int[] arr1 = {1,2,8,9,7};
         int[] arr2 = {1,3,2,10};
         System.out.println(sol.makeArrayIncreasing(arr1, arr2));
     }
}