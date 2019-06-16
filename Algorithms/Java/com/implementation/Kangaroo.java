// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class Kangaroo {
  static class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int x1 = in.nextInt();
      int v1 = in.nextInt();
      int x2 = in.nextInt();
      int v2 = in.nextInt();
      double factor = (x1 - x2) * 1.0 / (v2 - v1);
      if ((factor > 0 && factor % 1 == 0) || x1 == x2)
        System.out.println("YES");
      else
        System.out.println("NO");
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
