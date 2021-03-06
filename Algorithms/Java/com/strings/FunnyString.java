// Author: Sagar Malik
// https://github.com/SagarMalik


package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FunnyString {
  static class Solution {

    static String funnyString(String s) {
      int n = s.length();
      int l = 0, r = n - 1;
      while (l < r) {
        if (Math.abs(s.charAt(l) - s.charAt(++l)) != Math.abs(s.charAt(r) - s.charAt(--r)))
          return "Not Funny";

      }
      return "Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int q = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int qItr = 0; qItr < q; qItr++) {
        String s = scanner.nextLine();

        String result = funnyString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
      }

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
