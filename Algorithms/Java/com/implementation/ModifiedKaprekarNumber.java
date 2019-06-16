// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class ModifiedKaprekarNumber {

  static class Solution {

    static void kaprekarNumbers(int p, int q) {
      boolean found = false;
      for (int i = p; i <= q; i++) {
        if (iskaprekarNumber(i)) {
          System.out.print((found ? " " : "") + i);
          found = true;
        }
      }
      if (!found)
        System.out.println("INVALID RANGE");

    }

    static boolean iskaprekarNumber(long a) {
      int d = ("" + a).length();
      String sq = "" + a * a;
      int l = sq.length() - d;
      return a == ((l > 0 ? Integer.valueOf(sq.substring(0, l)) : 0)
          + Integer.valueOf(sq.substring(l)));
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      int p = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int q = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      kaprekarNumbers(p, q);

      scanner.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
