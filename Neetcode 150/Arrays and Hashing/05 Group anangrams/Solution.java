class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0) return new ArrayList<>();
        Map<String, List<String>> map =new HashMap<>();
        for(String s: strs){
            char []ch = s.toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());

            }
            map.get(sortedString).add(s);
           
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(sol.groupAnagrams(strs));
    }
}