// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.util.Scanner;

public class CommonChild {

  static class Solution {
    public static short LCS(String p1, String p2) {
      int m = p1.length();
      int n = p2.length();
      short[][] c = new short[m + 1][n + 1];
      for (int i = 1; i < m + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
          if (p1.charAt(i - 1) == p2.charAt(j - 1))
            c[i][j] = (short) (c[i - 1][j - 1] + 1);
          else
            c[i][j] = c[i][j - 1] > c[i - 1][j] ? c[i][j - 1] : c[i - 1][j];

        }


      }


      return c[m][n];
    }

    public static void main(String[] args) {
      /*
       * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
       * named Solution.
       */
      Scanner sc = new Scanner(System.in);
      String first = sc.next();
      String second = sc.next();
      System.out.println(LCS(first, second));
      sc.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
