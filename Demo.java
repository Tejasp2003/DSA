 class  Demo{
     // progarm to print 
    //  7 8 9 10
    //  4 5 6
    //  2 3
    //  1
  
    public static void main(String[] args) {
        int count = 7;
        int row =4;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
            count -= (2 * (row-i))-1;
        }
    
}


}