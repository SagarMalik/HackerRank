// Author: Sagar Malik
// https://github.com/SagarMalik


package com.strings;

import java.util.Scanner;

public class CamelCase {

  static class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String s = in.next();
      int words = 1;
      for (char c : s.toCharArray())
        if (c > 64 && c < 91)
          words++;
      System.out.println(words);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
