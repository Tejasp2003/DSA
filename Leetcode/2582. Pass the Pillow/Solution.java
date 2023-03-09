//problem link: https://leetcode.com/problems/pass-the-pillow/description/

class Solution {
    public int passThePillow(int n, int time) {
        int i=1;
        int direction=0;
        for(int t=1; t<=time; t++){
            if(i==n){
                direction = -1;
            }
            if(i==1){
                direction= 1;
            }
            i+=direction;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.passThePillow(5, 3));
    }
}