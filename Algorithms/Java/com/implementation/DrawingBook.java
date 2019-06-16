// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.util.Scanner;

public class DrawingBook {
  static class Solution {

    static int solve(int n, int p) {
      int desirepage = p / 2;
      int lastpage = n / 2;
      return desirepage < lastpage - desirepage ? desirepage : lastpage - desirepage;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int p = in.nextInt();
      int result = solve(n, p);
      System.out.println(result);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
