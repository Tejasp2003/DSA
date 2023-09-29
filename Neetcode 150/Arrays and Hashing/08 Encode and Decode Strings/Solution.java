import java.util.*;
class Solution {
// Encodes a list of Strings to a single String.
public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
        sb.append(str.length()).append('/').append(str);
    }
    return sb.toString();
}
// Decodes a single String to a list of Strings.
public List<String> decode(String s) {
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
        System.out.println("I: "+i);
        int slash = s.indexOf('/', i);  // s.indexOf('/', i) will  return the index of first occurence of '/' after i
        System.out.println("SLASH: "+slash);
        int size = Integer.valueOf(s.substring(i, slash));
        System.out.println("SIZE: "+size);
        res.add(s.substring(slash + 1, slash + size + 1));
        System.out.println("RES: "+res);
        i = slash + size + 1;
    }
    return res;
}
public static void main(String[] args){
    List<String> strs = new ArrayList<>();
    strs.add("abc");
    strs.add("def");
    strs.add("ghi");
    Solution sol = new Solution();
    String encoded = sol.encode(strs);
    System.out.println(encoded);
    List<String> decoded = sol.decode(encoded);
    for(String str: decoded){
        System.out.println(str);
    }

}
}