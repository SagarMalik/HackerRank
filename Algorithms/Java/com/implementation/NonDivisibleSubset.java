// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NonDivisibleSubset {

  static class Solution {

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
      int[] nums = new int[k];
      for (int a : S) {
        nums[a % k]++;
      }
      if (k % 2 == 0 && nums[k / 2] > 0)
        nums[k / 2] = 1;
      int ct = 0;
      for (int i = 1; i <= k / 2; i++)
        ct += Math.max(nums[i], nums[k - i]);
      ct += Math.min(nums[0], 1);
      return ct;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] nk = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nk[0]);

      int k = Integer.parseInt(nk[1]);

      int[] S = new int[n];

      String[] SItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int SItem = Integer.parseInt(SItems[i]);
        S[i] = SItem;
      }

      int result = nonDivisibleSubset(k, S);

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
