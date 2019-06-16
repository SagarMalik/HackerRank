// Author: Sagar Malik
// https://github.com/SagarMalik


package com.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LuckBalance {

  static class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
      Arrays.sort(contests, (int[] contest1, int[] contest2) -> {
        int diff = contest2[1] - contest1[1];
        return diff != 0 ? diff : contest1[0] - contest2[0];
      });
      int luckBalance = 0, i = contests.length - 1;
      while (i > -1 && (contests[i][1] != 1 || k-- > 0))
        luckBalance += contests[i--][0];
      while (i > -1)
        luckBalance -= contests[i--][0];

      return luckBalance;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] nk = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nk[0]);

      int k = Integer.parseInt(nk[1]);

      int[][] contests = new int[n][2];

      for (int i = 0; i < n; i++) {
        String[] contestsRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int contestsItem = Integer.parseInt(contestsRowItems[j]);
          contests[i][j] = contestsItem;
        }
      }

      int result = luckBalance(k, contests);

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
