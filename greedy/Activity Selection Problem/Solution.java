
import java.util.*;
class Solution{

    public static void main(String[] args) {
        // int startTime[]= {1,3,0,5,8,5};
        // int finishTime[]= {2,4,6,7,9,9};
        //unsorted

        int startTime[]= {5,1,3,0,8,5};
        int finishTime[]= {7,2,4,6,9,9};
        int [][] activities = new int[startTime.length][3];
        for(int i=0;i<startTime.length;i++){
            activities[i][0]=startTime[i]; // 0th column is start time
            activities[i][1]=finishTime[i]; // 1st column is finish time
            activities[i][2]=i; // 2nd column is activity number
        }
        System.out.println("Unsorted activities: ");
        for(int i=0;i<startTime.length;i++){
            System.out.print(activities[i][2]+" ");
        }

    

        //sort the activities based on finish time using comparator

        Arrays.sort(activities,  Comparator.comparingDouble(o->o[1]));

        System.out.println("\nSorted activities: ");
        for(int i=0;i<startTime.length;i++){
            System.out.print(activities[i][2]+" ");
        }

        //printing activities array
        System.out.println("\nActivities array: ");
        for(int i=0;i<startTime.length;i++){
            System.out.print(activities[i][0]+" "+activities[i][1]+" "+activities[i][2]+" ");
            System.out.println();
        }
        
        //select the first activity

    

        

        int n=startTime.length;
        ArrayList<Integer> ans=new ArrayList<>();
        System.out.println("\n activities[0][2] "+ activities[0][2]);      
        ans.add(activities[0][2]);
        int prev=0;
        for(int i=1;i<n;i++){
            if(activities[i][0]>=activities[prev][1]){
                ans.add(activities[i][2]);
                prev= i;
            }
        }
        int total=ans.size();
        System.out.println("\nSelected activities: ");


        for(int i=0;i<ans.size();i++){

            System.out.print( ans.get(i)+" ");
        }
        System.out.println( "Total activities: "+total);

    }
}