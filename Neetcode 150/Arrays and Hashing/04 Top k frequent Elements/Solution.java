// // Heap 
// // Time Complexity: O(nlogk)
// // Space Complexity: O(n)


// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i : nums){
//             map.put(i, map.getOrDefault(i, 0)+1);

//         }
//         PriorityQueue<Integer> pq = new PriorityQueue((i, j)-> map.get(i)-map.get(j));
//         System.out.println(map);
//         for(int i: map.keySet()){
//             pq.offer(i);
//             System.out.println(pq);
//             if(pq.size()>k){
//                 pq.remove();
//             }
//             System.out.println("after: "+pq);
//         }
//         int ans []= new int[k];
//         for(int i=k-1; i>=0; i--){
//             ans[i]=pq.poll();
//         }
//         return ans;
//     }
    
// }

// 2 nd approach using bucket sort

//intution: Here we are using bucket sort, we are creating a bucket of size nums.length+1, because the maximum frequency can be nums.length, so we are creating a bucket of size nums.length+1, and then we are storing the frequency of each element in the bucket, and then we are iterating from the end of the bucket, and we are storing the elements in the result array, and we are returning the result array.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> bucket[] = new ArrayList[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq]= new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int result[]= new int[k];
        int index=0;
        for(int i=bucket.length-1; i>=0; i--){
            if(bucket[i]!=null){
                for(int val: bucket[i]){
                    result[index++]= val;
                    if(index==k) return result;
                } 
            }
        }
        return result;
    }
}