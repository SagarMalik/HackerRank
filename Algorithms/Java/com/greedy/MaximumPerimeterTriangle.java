// Author: Sagar Malik
// https://github.com/SagarMalik

package com.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumPerimeterTriangle {

  static class Solution {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
      Arrays.sort(sticks);
      int n = sticks.length;
      for (int i = n - 1; i > 1; i--) {
        if (sticks[i] < sticks[i - 1] + sticks[i - 2])
          return Arrays.copyOfRange(sticks, i - 2, i + 1);
      }
      return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] sticks = new int[n];

      String[] sticksItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int sticksItem = Integer.parseInt(sticksItems[i]);
        sticks[i] = sticksItem;
      }

      int[] result = maximumPerimeterTriangle(sticks);
      if (result == null)
        bufferedWriter.write(String.valueOf(-1));
      else {
        for (int i = 0; i < result.length; i++) {
          bufferedWriter.write(String.valueOf(result[i]));

          if (i != result.length - 1) {
            bufferedWriter.write(" ");
          }
        }
      }
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
