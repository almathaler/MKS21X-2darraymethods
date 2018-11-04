public class ArrayMethods{
  //
  //NOT MY CODE!!! FROM MR. KONSTANTINOVICH'S SITE
  //
  public static String toString(int[]ary){
    String res = "{";
    for(int i = 0; i < ary.length; i++){
      res+=ary[i];
      if(i<ary.length-1){
        res+=", ";
      }
    }
    return res+"}";
  }
  public static String toString(int[][]ary){
    String res = "{";
    for(int i = 0; i < ary.length; i++){
      res+=toString(ary[i]);
      if(i<ary.length-1)res+=", \n";
    }
    return res+"}";
  }
  //
  //
  //
  public static int rowSum(int[][] ary, int x) {
    //returns the sum of the elements in row x of the ary
    int sumRow = 0;
    for (int i = 0; i<ary[x].length; i++) {
      sumRow+=ary[x][i];
    }
    return sumRow;
  }
  //
  public static int columnSum(int[][] ary, int x) {
    int sumColumn = 0;
    for (int i = 0; i<ary.length; i++) {
      if (x < ary[i].length) {
        sumColumn+=ary[i][x];
      }
    }
    return sumColumn;
  }
  //
  public static int[] allRowSums(int[][] ary) {
    int[] aryReturn = new int[ary.length];
    for (int i = 0; i<ary.length; i++) {
      aryReturn[i] = rowSum(ary, i);
    }
    return aryReturn;
  }
  //
  //MAIN
  //
  public static void main(String[] args) {
    int[][] ary1 = {{1, 2, 3, 4},
                    {2, 4, 6, 8},
                    {1, 3, 5, 7}};
    //testing rowSum
    System.out.println("This is what ary1 looks like: " + toString(ary1));
    System.out.println("This is the sum of the rows (expect 10, 20, 16): " + rowSum(ary1, 0) + ", " + rowSum(ary1, 1) + ", " + rowSum(ary1, 2));
    //testing columnSum
    System.out.println("This is the sum of each column (expect 4, 9, 14, 19): " + columnSum(ary1, 0) + ", " + columnSum(ary1, 1) + ", " + columnSum(ary1, 2) + ", " + columnSum(ary1, 3));
    int[][] ary2 = {{1, 2, 3,},
                    {2, 4, 6, 8},
                    {5, 7}};
    System.out.println("This is what ary2 looks like: " + toString(ary2));
    System.out.println("Can we still add these rows? (expect 8, 13, 9, 8): " + columnSum(ary2, 0) + ", " + columnSum(ary2, 1) + ", " + columnSum(ary2, 2) + ", " + columnSum(ary2, 3));
    //testing allRowSums
    System.out.println("--ALL--ROW--SUM--");
    System.out.println("This is the sum of the rows of ary1, in one array (expect {10, 20,16}): " + toString(allRowSums(ary1)));
  }
}
