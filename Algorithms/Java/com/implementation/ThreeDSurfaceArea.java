// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThreeDSurfaceArea {

  static class Solution {

    static int surfaceArea(int[][] grid) {
      int m = grid.length, n = grid[0].length;
      int area = 2 * m * n;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {

          area += getPart(grid, m, n, i, j, -1, 0);
          area += getPart(grid, m, n, i, j, 1, 0);
          area += getPart(grid, m, n, i, j, 0, -1);
          area += getPart(grid, m, n, i, j, 0, 1);
        }
      }
      return area;
    }

    static int getPart(int[][] grid, int m, int n, int x, int y, int xInc, int yInc) {
      if (x + xInc < 0 || x + xInc >= m || y + yInc < 0 || y + yInc >= n)
        return grid[x][y];
      int j = grid[x][y] - grid[x + xInc][y + yInc];
      return j > 0 ? j : 0;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] HW = scanner.nextLine().split(" ");

      int H = Integer.parseInt(HW[0]);

      int W = Integer.parseInt(HW[1]);

      int[][] A = new int[H][W];

      for (int i = 0; i < H; i++) {
        String[] ARowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < W; j++) {
          int AItem = Integer.parseInt(ARowItems[j]);
          A[i][j] = AItem;
        }
      }

      int result = surfaceArea(A);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
