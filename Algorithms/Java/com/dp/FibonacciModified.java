// Author: Sagar Malik
// https://github.com/SagarMalik


package com.dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

  static class Solution {

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {
      if (n == 1)
        return BigInteger.valueOf(t1);
      if (n == 2)
        return BigInteger.valueOf(t2);
      BigInteger bt1 = BigInteger.valueOf(t1), bt2 = BigInteger.valueOf(t2);
      BigInteger temp = bt2;
      while (n > 2) {
        bt2 = bt2.multiply(bt2).add(bt1);
        bt1 = temp;
        temp = bt2;
        n--;
      }
      return bt2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] t1T2n = scanner.nextLine().split(" ");

      int t1 = Integer.parseInt(t1T2n[0]);

      int t2 = Integer.parseInt(t1T2n[1]);

      int n = Integer.parseInt(t1T2n[2]);

      BigInteger result = fibonacciModified(t1, t2, n);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);
  }

}
