// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class MigratoryBird {
  static class Solution {

    static int migratoryBirds(int n, int[] ar) {
      int[] typecount = new int[6];

      for (int i = 0; i < n; i++)
        typecount[ar[i]]++;
      int maxcount = 0, id = 0;
      for (int i = 1; i < typecount.length; i++) {
        if (typecount[i] > maxcount) {
          maxcount = typecount[i];
          id = i;
        }
      }
      return id;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] ar = new int[n];
      for (int ar_i = 0; ar_i < n; ar_i++) {
        ar[ar_i] = in.nextInt();
      }
      int result = migratoryBirds(n, ar);
      System.out.println(result);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);
  }

}
