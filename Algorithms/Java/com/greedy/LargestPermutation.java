// Author: Sagar Malik
// https://github.com/SagarMalik


package com.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LargestPermutation {

  static class Solution {

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {
      int n = arr.length;
      int max = Integer.MIN_VALUE, maxIndex = -1;
      for (int i = 0; i < n && k > 0; i++) {
        max = n - i;
        maxIndex = i;
        for (int j = i; j < n && k > 0; j++) {
          if (arr[j] == max) {
            maxIndex = j;
            break;
          }
        }
        if (maxIndex != i) {
          int t = arr[i];
          arr[i] = max;
          arr[maxIndex] = t;
          k--;
        }
      }
      return arr;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] nk = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nk[0]);

      int k = Integer.parseInt(nk[1]);

      int[] arr = new int[n];

      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
      }

      int[] result = largestPermutation(k, arr);

      for (int i = 0; i < result.length; i++) {
        bufferedWriter.write(String.valueOf(result[i]));

        if (i != result.length - 1) {
          bufferedWriter.write(" ");
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
