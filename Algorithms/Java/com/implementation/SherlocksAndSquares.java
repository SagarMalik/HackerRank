// Author: Sagar Malik
// https://github.com/SagarMalik
package com.implementation;

import java.util.Scanner;

public class SherlocksAndSquares {

  static class Solution {

    static int squares(int a, int b) {
      int leftSqrt = (int) Math.floor(Math.sqrt(a));
      int rightSqrt = (int) Math.floor(Math.sqrt(b));

      int sum = rightSqrt - leftSqrt + 1;
      if (leftSqrt * leftSqrt != a)
        sum -= 1;

      return sum;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int q = in.nextInt();
      for (int a0 = 0; a0 < q; a0++) {
        int a = in.nextInt();
        int b = in.nextInt();
        int result = squares(a, b);
        System.out.println(result);
      }
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
