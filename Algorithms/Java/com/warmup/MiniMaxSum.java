// Author: Sagar Malik
// https://github.com/SagarMalik

package com.warmup;

import java.util.Scanner;

public class MiniMaxSum {

  static class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
      long sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
      for (int a : arr) {
        sum += a;
        min = Math.min(min, a);
        max = Math.max(max, a);
      }
      System.out.println((sum - max) + " " + (sum - min));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      int[] arr = new int[5];

      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < 5; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
      }

      miniMaxSum(arr);

      scanner.close();
    }
  }


  public static void main(String[] args) {
    Solution.main(args);
  }
}
