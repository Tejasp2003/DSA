class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));
        int ans=1;
        int chainEnd= pairs[0][1];
        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0]<=chainEnd){
                continue;
            }
            chainEnd = pairs[i][1];
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println(s.findLongestChain(pairs));
    }
}