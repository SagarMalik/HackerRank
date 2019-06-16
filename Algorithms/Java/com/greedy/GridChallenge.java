package com.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

  static class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(char[][] grid) {
      for (char[] chars : grid)
        Arrays.sort(chars);
      int cols = grid[0].length;
      int rows = grid.length;
      for (int col = 0; col < cols; col++) {
        for (int row = 0; row < rows - 1; row++) {
          if (grid[row][col] > grid[row + 1][col]) {
            return "NO";
          }
        }
      }

      return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        char[][] grid = new char[n][];

        for (int i = 0; i < n; i++) {
          String gridItem = scanner.nextLine();
          grid[i] = gridItem.toCharArray();
        }

        String result = gridChallenge(grid);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
      }

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
