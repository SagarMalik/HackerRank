// Author: Sagar Malik
// https://github.com/SagarMalik


package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoStrings {

  static class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
      boolean[] isPresent = new boolean[128];
      int n1 = s1.length(), n2 = s2.length();
      char c;
      for (int i = 0; i < n1; i++) {
        c = s1.charAt(i);
        isPresent[(int) c] = true;
      }
      for (int i = 0; i < n2; i++) {
        c = s2.charAt(i);
        if (isPresent[(int) c])
          return "YES";
      }
      return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int q = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int qItr = 0; qItr < q; qItr++) {
        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        String result = twoStrings(s1, s2);

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
