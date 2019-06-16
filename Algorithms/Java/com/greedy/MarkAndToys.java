// Author: Sagar Malik
// https://github.com/SagarMalik


package com.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

  static class Solution {

    static int maximumToys(int[] prices, int k) {
      Arrays.parallelSort(prices);
      int sum = 0;
      for (int i = 0; i < prices.length; i++) {
        if (sum + prices[i] > k)
          return i;
        sum += prices[i];
      }
      return prices.length;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int k = in.nextInt();
      int[] prices = new int[n];
      for (int prices_i = 0; prices_i < n; prices_i++) {
        prices[prices_i] = in.nextInt();
      }
      int result = maximumToys(prices, k);
      System.out.println(result);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);
  }

}
