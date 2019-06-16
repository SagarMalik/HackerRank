// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

  static class Solution {

    static void extraLongFactorials(int n) {
      if (n < 2) {
        System.out.println("1");
        return;
      }
      BigInteger result = BigInteger.ONE;
      while (n > 1) {
        result = result.multiply(new BigInteger("" + n--));
      }
      System.out.println(result);
      return;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      extraLongFactorials(n);

      scanner.close();
    }
  }


  public static void main(String[] args) {
    Solution.main(args);

  }

}
