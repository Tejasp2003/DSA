import java.util.*;
class Solution{
    public static int kthSmallest(int[] arr,int k) 
    { 
        int size = arr.length;
        PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i =0; i<size; i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k){
                System.out.println(maxHeap);
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    } 
    public static void main(String[] args) {
        
        int [] arr= {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));

    }

}