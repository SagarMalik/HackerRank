// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class UtopianTree {

  static class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();
      for (int a0 = 0; a0 < t; a0++) {
        int n = in.nextInt();
        int initial_height = 1;
        for (int i = 1; i <= n; i++) {
          if (i % 2 == 1)
            initial_height *= 2;
          else
            initial_height++;
        }
        System.out.println(initial_height);
      }
      in.close();
    }
  }


  public static void main(String[] args) {
    Solution.main(args);

  }

}
