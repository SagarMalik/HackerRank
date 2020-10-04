// Author: Sagar Malik
// https://github.com/SagarMalik


package com.dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CoinChangeProblem {
  static class Solution {

    // Complete the getWays function below.
    static long getWays(int target, int[] coins) {
      long[] ways = new long[target + 1];
      ways[0] = 1;

      for (int coin : coins) {
        for (int current = coin, prev = 0; current <= target; current++, prev++) {
          ways[current] += ways[prev];

        }
      }
      return ways[target];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] nm = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nm[0]);

      int m = Integer.parseInt(nm[1]);

      int[] c = new int[m];

      String[] cItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < m; i++) {
        int cItem = Integer.parseInt(cItems[i]);
        c[i] = cItem;
      }

      // Print the number of ways of making change for 'n' units using coins having the values given
      // by 'c'

      long ways = getWays(n, c);
      bufferedWriter.write(String.valueOf(ways));
      bufferedWriter.newLine();
      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);
  }
}
