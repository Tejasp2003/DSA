import java.util.*;
class Solution{
    public static void main(String[] args) {
        
        int wt[] = {10,40,20,30};
        int val[] = {60,40,100,120};
        int capacity = 50;

        double[][] items = new double[wt.length][2];
        for(int i=0;i<wt.length;i++){
            items[i][0]=i; // 0th column is index
            items[i][1]=val[i]/(double)wt[i];  // 1st column is value/weight
        }

        Arrays.sort(items, Comparator.comparingDouble(o->o[1]));

        double ans=0;
        for(int i= items.length-1; i>=0; i--){
            if(wt[(int)items[i][0]]<=capacity){
                ans+= val[(int)items[i][0]];
                capacity-= wt[(int)items[i][0]];
            }
            else{
                ans+= items[i][1]*capacity;
                break;
            }
        }
        System.out.println(ans);
    }
    
}