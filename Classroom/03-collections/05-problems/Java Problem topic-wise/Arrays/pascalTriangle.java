package Arrays;

import java.util.Arrays;

public class pascalTriangle {

  
  public static int[] getPascalRow_Brute(int rowIndex) {
    int[] row = new int[rowIndex + 1];
    row[0] = 1;
    for (int i = 1; i <= rowIndex; i++) {
      row[i] = nCr(rowIndex, i); 
    }
    return row;
  }

  public static int[] getPascalRow_Better(int rowIndex) {
    int[] row = new int[rowIndex + 1];
    row[0] = 1;
    long ans = 1; 
    for (int i = 1; i <= rowIndex; i++) {
      ans = ans * (rowIndex - i + 1) / i;
      row[i] = (int) ans;
    }
    return row;
  }


  public static int printIthAndJthElement(int i, int j) {
    return nCr(i, j);
  }

  public static int nCr(int row, int col) {
    col = Math.min(col, row - col); // nCr = nC(n-r)
    long result = 1;
    for (int i = 1; i <= col; i++) {
      result = result * (row - i + 1) / i;
    }
    return (int) result;
  }

  public static void main(String[] args) {
    int rowIndex = 4;
    int[] result1 = getPascalRow_Better(rowIndex);
    int [] result2 = getPascalRow_Brute(rowIndex);

    System.out.println("Pascal's Triangle Row " + rowIndex + " (Brute): " + Arrays.toString(result2));
    System.out.println("Pascal's Triangle Row " + rowIndex + " (Better): " + Arrays.toString(result1));
    System.out.println();

    System.out.println(printIthAndJthElement(0, 0));
  }
}
