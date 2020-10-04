package com.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConnectedCellsInAGrid {

  static class Solution {
    static int n, m;
    static int[][] matrix;
    static final int[] offsets = new int[] {-1, 0, 1};

    static boolean canVisit(int x, int y) {
      return x > -1 && x < n && y > -1 && y < m && matrix[x][y] == 1;
    }

    static int dfs(int x, int y) {
      int count = 1;
      int nextX, nextY;
      matrix[x][y] = -1;
      for (int i : offsets) {
        for (int j : offsets) {
          nextX = x + i;
          nextY = y + j;
          if (canVisit(nextX, nextY))
            count += dfs(nextX, nextY);
        }
      }



      return count;
    }

    static int connectedCell() {
      int maxRegionCount = 0, regionCount;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (matrix[i][j] == 1) {
            regionCount = dfs(i, j);
            maxRegionCount = Math.max(regionCount, maxRegionCount);
          }
        }

      }

      return maxRegionCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      m = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      matrix = new int[n][m];

      for (int i = 0; i < n; i++) {
        String[] matrixRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < m; j++) {
          int matrixItem = Integer.parseInt(matrixRowItems[j]);
          matrix[i][j] = matrixItem;
        }
      }

      int result = connectedCell();

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) {


  }

}
