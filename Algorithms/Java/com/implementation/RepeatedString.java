// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

  static class Solution {

    static long repeatedString(String s, long n) {
      int n2 = s.length(), k = (int) (n % n2);
      long ct = 0, f = n / n2;
      n2 = f > 0 ? n2 : k;
      for (int i = 0; i < n2; i++) {
        if (s.charAt(i) == 'a') {
          ct += f;
          if (i < k)
            ct++;
        }
      }
      return ct;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String s = scanner.nextLine();

      long n = scanner.nextLong();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      long result = repeatedString(s, n);

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
