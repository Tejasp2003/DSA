import java.util.*;

class Solution{
    static class Jobs{
        int id;
        int deadline;
        int profit;
        Jobs(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{1,4,20}, {2,1,10}, {3,1,40}, {4,1,30}};
        ArrayList<Jobs> jobs = new ArrayList<>();
        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new Jobs(jobsInfo[i][0], jobsInfo[i][1], jobsInfo[i][2]));
        }
        Collections.sort(jobs, (a,b)->b.profit-a.profit);
        int time = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0; i<jobs.size(); i++){
            Jobs currJob = jobs.get(i);
            if(currJob.deadline> time){
                
                ans.add(currJob.id);
                time++;
            }
        }
        System.out.println(ans);
        System.out.println("Total Profit: "+ans.stream().mapToInt(i->jobsInfo[i-1][2]).sum());
    }
}