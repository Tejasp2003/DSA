import java.util.*;
class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        ArrayList< Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int i =0; i<num; i++){
            minHeap.add(arr[i]);
            if(minHeap.size()>k){
                ans.add(minHeap.peek());
                minHeap.remove();
            }
        }
        while(minHeap.size()>0){
            ans.add(minHeap.peek());
            minHeap.remove();
        }
        //list to array
        // int[] arr = new int[list.size()];
        // for (int i = 0; i < list.size(); i++) {
        //     arr[i] = list.get(i);
        // }
        

            
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        Solution obj = new Solution();
        ArrayList<Integer> ans = obj.nearlySorted(arr, arr.length, k);
        for(int i =0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
