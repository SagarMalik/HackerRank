// Author: Sagar Malik
// https://github.com/SagarMalik

package com.warmup;

import java.util.Scanner;

public class PlusMinus {
  static class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int arr[] = new int[n];
      double neg = 0.0, pos = 0.0, zero = 0.0;
      for (int arr_i = 0; arr_i < n; arr_i++) {
        arr[arr_i] = in.nextInt();
      }
      for (int i = 0; i < n; i++) {
        if (arr[i] > 0)
          pos += 1;
        else if (arr[i] < 0)
          neg += 1;
        else
          zero += 1;

      }
      System.out.println(pos / n + "\r\n" + neg / n + "\r\n" + zero / n);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
