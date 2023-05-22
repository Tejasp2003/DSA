import java.util.Arrays;
class Solution { 
    long findMinSum(int[] A,int[] B,int N) { 
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length;
        long sum=0;
        for(int i =0; i<n; i++){
            sum+=Math.abs(A[i]-B[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] A = {4,1,8,7};
        int[] B = {2,3,6,5};
        int N = 4;
        System.out.println(obj.findMinSum(A, B, N));
    }
}