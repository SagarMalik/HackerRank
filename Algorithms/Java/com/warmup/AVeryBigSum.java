// Author: Sagar Malik
// https://github.com/SagarMalik


package com.warmup;

import java.util.Scanner;

public class AVeryBigSum {
  static class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      long sum = 0;
      int arr[] = new int[n];
      for (int arr_i = 0; arr_i < n; arr_i++) {
        arr[arr_i] = in.nextInt();
        sum += arr[arr_i];
      }
      System.out.println(sum);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
