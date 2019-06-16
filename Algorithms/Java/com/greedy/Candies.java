// Author: Sagar Malik
// https://github.com/SagarMalik


package com.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Candies {

  static class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
      if (n == 0)
        return 0l;
      if (n == 1)
        return 1l;
      int[] c1 = new int[n], c2 = new int[n];
      int start = 1;
      c1[0] = 1;
      for (int i = 1; i < n; i++) {
        if (arr[i] > arr[i - 1])
          start++;
        else
          start = 1;
        c1[i] = start;
      }
      start = 1;
      c2[n - 1] = start;
      for (int i = n - 2; i >= 0; i--) {
        if (arr[i] > arr[i + 1])
          start++;
        else
          start = 1;
        c2[i] = start;
      }
      long sum = 0;
      for (int i = 0; i < n; i++) {
        sum += Math.max(c1[i], c2[i]);
      }
      return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
        int arrItem = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        arr[i] = arrItem;
      }

      long result = candies(n, arr);

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
