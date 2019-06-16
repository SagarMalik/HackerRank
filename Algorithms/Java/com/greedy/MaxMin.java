// Author: Sagar Malik
// https://github.com/SagarMalik

package com.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

  static class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
      Arrays.sort(arr);
      int min = Integer.MAX_VALUE;
      for (int i = k - 1; i < arr.length; i++) {
        min = Math.min(arr[i] - arr[i - k + 1], min);
      }
      return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int k = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
        int arrItem = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        arr[i] = arrItem;
      }

      int result = maxMin(k, arr);

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