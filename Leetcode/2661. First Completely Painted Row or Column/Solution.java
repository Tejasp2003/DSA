class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // put the row col of each number in map
        Map<Integer, int[]> map = new HashMap<>();
        for(int row=0; row<mat.length; row++){
            for(int col=0; col<mat[0].length; col++){
                map.put(mat[row][col], new int[]{row, col});
            }
        }

        int[] rowCounter = new int[mat.length];
        int colCounter[]= new int[mat[0].length];

        for(int i=0; i<arr.length; i++){
            int[] array = map.get(arr[i]);
            rowCounter[array[0]]++;
            colCounter[array[1]]++;
            if(rowCounter[array[0]]==mat[0].length || colCounter[array[1]]==mat.length) return i;
        }
        return -1;
    }
}