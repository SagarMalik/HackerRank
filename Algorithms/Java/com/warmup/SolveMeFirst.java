// Author: Sagar Malik
// https://github.com/SagarMalik


package com.warmup;

import java.util.Scanner;

public class SolveMeFirst {
  static class Solution {


    static int solveMeFirst(int a, int b) {
      return a + b;
    }


    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int a;
      a = in.nextInt();
      int b;
      b = in.nextInt();
      int sum;
      sum = solveMeFirst(a, b);
      System.out.println(sum);
      in.close();
    }
  }



  public static void main(String[] args) {
    Solution.main(args);

  }

}
