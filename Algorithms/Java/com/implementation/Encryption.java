// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {

  static class Solution {

    static String encryption(String s) {
      int l = s.length();
      double sq = Math.sqrt(l);
      int row = (int) Math.floor(sq), column = (int) Math.ceil(sq);
      if (row * column < l)
        row += 1;
      StringBuilder sb = new StringBuilder();
      int k = 0;
      for (int i = 0; i < column; i++) {
        for (int j = 0; j < row; j++) {
          k = i + j * column;
          if (k < l)
            sb.append(s.charAt(k));
        }
        sb.append(' ');

      }
      return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String s = scanner.nextLine();

      String result = encryption(s);

      bufferedWriter.write(result);
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
