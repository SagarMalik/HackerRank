// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GridSearch {

  static class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
      int grid_rows = G.length;
      int grid_cols = G[0].length();
      int pat_rows = P.length;
      int pat_cols = P[0].length();
      int curr_row = 0, k;

      if (pat_cols > grid_cols || pat_rows > grid_rows)
        return "NO";
      boolean found = false;
      for (int startIndex = -1; startIndex <= grid_cols - pat_cols; startIndex++) {

        curr_row = -1;
        k = startIndex;
        while (++curr_row <= grid_rows - pat_rows) {
          found = false;

          for (; curr_row < grid_rows; curr_row++) {
            k = G[curr_row].indexOf(P[0], startIndex);
            if (k > -1) {
              found = true;

              break;
            }
          }
          if (!found)
            return "NO";

          for (int j = 1; curr_row + j < grid_rows && j < pat_rows; j++) {
            if (G[curr_row + j].indexOf(P[j], startIndex) != k) {
              found = false;
              break;
            }
          }
          if (!found)
            continue;
          return "YES";
        }
      }
      return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
        String[] RC = scanner.nextLine().split(" ");

        int R = Integer.parseInt(RC[0]);

        // int C = Integer.parseInt(RC[1]);

        String[] G = new String[R];

        for (int i = 0; i < R; i++) {
          String GItem = scanner.nextLine();
          G[i] = GItem;
        }

        String[] rc = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rc[0]);

        // int c = Integer.parseInt(rc[1]);

        String[] P = new String[r];

        for (int i = 0; i < r; i++) {
          String PItem = scanner.nextLine();
          P[i] = PItem;
        }

        String result = gridSearch(G, P);

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
