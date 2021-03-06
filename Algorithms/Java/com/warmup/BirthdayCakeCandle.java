// Author: Sagar Malik
// https://github.com/SagarMalik

package com.warmup;

import java.util.Scanner;

public class BirthdayCakeCandle {

  static class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
      int count = 0;
      int max = -1;
      for (int i = 0; i < n; i++) {
        if (ar[i] > max) {
          max = ar[i];
          count = 1;

        } else if (ar[i] == max)
          count++;
      }
      return count;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] ar = new int[n];
      for (int ar_i = 0; ar_i < n; ar_i++) {
        ar[ar_i] = in.nextInt();
      }
      int result = birthdayCakeCandles(n, ar);
      System.out.println(result);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
