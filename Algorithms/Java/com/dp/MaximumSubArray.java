// Author: Sagar Malik
// https://github.com/SagarMalik

package com.dp;

import java.util.Scanner;

public class MaximumSubArray {

  static class Solution {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int i = sc.nextInt(), n = 0;
      int[] arr;
      int result1, result2;

      while (i-- > 0) {
        n = sc.nextInt();
        arr = lineInput(sc, n);
        result1 = contiguousum(arr);
        result2 = noncontiguousum(arr);
        System.out.println(result1 + " " + result2);
      }
      sc.close();

    }

    private static int contiguousum(int[] arr) {
      // give maximum sum of contiguous range
      int maxsum = arr[0];
      int localsum = arr[0];
      for (int i = 1; i < arr.length; i++) {
        localsum = localsum + arr[i] > arr[i] ? localsum + arr[i] : arr[i];
        maxsum = localsum > maxsum ? localsum : maxsum;
      }
      return maxsum;
    }

    private static int noncontiguousum(int[] arr) {
      // give maxium sum of non contiguous range
      int maxsum = arr[0];
      boolean fneg = maxsum < 0 ? true : false;
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] < 0) {
          if (fneg)
            maxsum = maxsum < arr[i] ? arr[i] : maxsum;
        } else {
          if (fneg) {
            fneg = false;
            maxsum = 0;
          }
          maxsum += arr[i];
        }
      }
      return maxsum;
    }

    public static int[] lineInput(Scanner sc, int arrsize) {
      int[] result = new int[arrsize];
      for (int i = 0; i < arrsize; i++)
        result[i] = sc.nextInt();

      return result;
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
