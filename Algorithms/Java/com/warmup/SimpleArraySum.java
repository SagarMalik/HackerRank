// Author: Sagar Malik
// https://github.com/SagarMalik

package com.warmup;

import java.util.Scanner;

public class SimpleArraySum {
  static class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int sum = 0;
      for (int arr_i = 0; arr_i < n; arr_i++) {
        sum += in.nextInt();
      }
      System.out.print(sum);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
