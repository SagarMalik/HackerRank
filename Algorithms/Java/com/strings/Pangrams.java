// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pangrams {

  static class Solution {
    static int[] mapper = new int[128];
    static {
      int i = 0;
      for (; i < 'A'; i++)
        mapper[i] = 26;
      for (; i <= 'Z'; i++)
        mapper[i] = i - 'A';
      for (; i < 'a'; i++)
        mapper[i] = 26;
      for (; i <= 'z'; i++)
        mapper[i] = i - 'a';
      for (; i < 128; i++)
        mapper[i] = 26;
    }

    // Complete the pangrams function below.
    static String pangrams(String s) {
      int n, counter = 26;
      if ((n = s.length()) < 26)
        return "not pangram";
      int c;
      boolean[] f = new boolean[27];
      f[26] = true;
      for (int i = 0; i < n; i++) {
        c = mapper[s.charAt(i)];
        if (!f[c]) {
          f[c] = true;
          counter--;
          if (counter == 0)
            return "pangram";
        }

      }


      return "not pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String s = scanner.nextLine();

      String result = pangrams(s);

      bufferedWriter.write(result);
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
