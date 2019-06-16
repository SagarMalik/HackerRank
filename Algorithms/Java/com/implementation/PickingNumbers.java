// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;


import java.util.Scanner;

public class PickingNumbers {

  static class Solution {

    static int pickingNumbers(int[] a) {
      int[] counter = new int[101];
      for (int i : a)
        counter[i]++;
      int max = 0;
      int sum = 0;
      for (int i = 0; i < 100; i++) {
        sum = counter[i] + counter[i + 1];
        max = max > sum ? max : sum;
      }
      return max;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] a = new int[n];
      for (int a_i = 0; a_i < n; a_i++) {
        a[a_i] = in.nextInt();
      }
      int result = pickingNumbers(a);
      System.out.println(result);
      in.close();
    }
  }


  public static void main(String[] args) {
    Solution.main(args);

  }

}
