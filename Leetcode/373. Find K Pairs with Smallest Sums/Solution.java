class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return lst;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for(int i = 0; i < nums1.length && i < k; i++)
            pq.offer(new int[]{nums1[i], nums2[0], 0});//pushing first k pairs in the heap 
            // 0 is the index of nums2 array
        while(k > 0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            lst.add(Arrays.asList(cur[0], cur[1]));
            k--;
            if(cur[2] == nums2.length - 1)//if we have reached the end of nums2 array then we can't move further in nums2 array so we  move to next pair in the heap 
                continue;
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});//pushing the next pair in the heap 
            // cur[2] + 1 is the index of nums2 array  

        }
        return lst;



        
    }
}