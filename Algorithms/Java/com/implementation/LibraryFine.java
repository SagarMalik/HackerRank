// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class LibraryFine {

  static class Solution {

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
      return y1 < y2 ? 0
          : y1 == y2 ? m1 < m2 ? 0 : (m1 == m2) ? d1 <= d2 ? 0 : 15 * (d1 - d2) : 500 * (m1 - m2)
              : 10000;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int d1 = in.nextInt();
      int m1 = in.nextInt();
      int y1 = in.nextInt();
      int d2 = in.nextInt();
      int m2 = in.nextInt();
      int y2 = in.nextInt();
      int result = libraryFine(d1, m1, y1, d2, m2, y2);
      System.out.println(result);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
