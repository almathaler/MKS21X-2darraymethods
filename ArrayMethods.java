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
  //now my code
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
  public static int longestRow(int[][] ary) {
    //returns longest row, so we know how long to make aryReturn for below methods
    int longest = 0;
    for (int i = 0; i<ary.length; i++) {
      if (ary[i].length > longest) {
        longest = ary[i].length;
      }
    }
    return longest;
  }
  //
  public static int[] allColSums(int[][] ary) {
    int[] aryReturn = new int[longestRow(ary)];
    for (int i = 0; i<longestRow(ary); i++) {
      aryReturn[i] = columnSum(ary, i);
    }
    return aryReturn;
  }
  //
  public static boolean isRowMagic(int[][] ary) {
    int[] rowSum = allRowSums(ary);
    int magicSum = rowSum[0];
    for (int i = 0; i<rowSum.length; i++) {
      if (rowSum[i] != magicSum) {
        return false;
      }
    }
    return true;
  }
  //
  public static boolean isColumnMagic (int[][] ary) {
    int[] columnSum = allColSums(ary);
    int magicSum = columnSum[0];
    for (int i =0; i<columnSum.length; i++) {
      if (columnSum[i] != magicSum) {
        return false;
      }
    }
    return true;
  }
  /*/
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
    System.out.println("--ALL--ROW--SUMS--");
    System.out.println("This is the sum of the rows of ary1, in one array (expect {10, 20,16}): " + toString(allRowSums(ary1)));
    //testing allColSums
    System.out.println("--ALL-COL--SUMS--");
    System.out.println("This is the sum of the columns of ary1, in one array (expect {4, 9, 14, 19}): " + toString(allColSums(ary1)));
    //testing isRowMagic
    int[][] ary3 = {{1, 2, 3, 4}, //has rowMagic
                    {4, 3, 2, 1},
                    {2, 3, 4, 1}};
    System.out.println("Made ary3, which should have isRowMagic: " + toString(ary3));
    System.out.println("allRowSums of ary3?(expect {10, 10, 10}): " + toString(allRowSums(ary3)));
    System.out.println("Does ary3 have rowMagic?: " + isRowMagic(ary3));
    System.out.println("Does ary2 and ary1 have rowMagic?: " + isRowMagic(ary2) + ", " + isRowMagic(ary1));
    //Testing isColumnMagic
    int[][] ary4 = {{1, 2, 3, 4},
                    {2, 1, 4, 3},
                    {4, 4}};
    System.out.println("Made ary4, which should have columnMagic: " + toString(ary4));
    System.out.println("allColSums of ary4?(expect {7, 7, 7, 7}): " + toString(allColSums(ary4)));
    System.out.println("Does this have colMagic?: " + isColumnMagic(ary4));
    System.out.println("Do ary1, 2 or 3 have colMagic? (no): " + isColumnMagic(ary1) + ", " + isColumnMagic(ary2) + ", " + isColumnMagic(ary3));
  }
  /*/
}
