// Author: Sagar Malik
// https://github.com/SagarMalik


package com.search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pairs {
  static class Solution {
    static int pairs(int[] a, int k) {
      /* Complete this function */
      Set<Integer> upper = new HashSet<Integer>();
      Set<Integer> lower = new HashSet<Integer>();
      int count = 0;
      int l, g;
      for (int num : a) {
        l = num - k;
        g = num + k;
        if (lower.contains(num)) {
          count++;
          lower.remove(num);
        }
        lower.add(l);
        if (upper.contains(num)) {
          count++;
          upper.remove(num);
        }
        upper.add(g);

      }
      return count;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int res;

      String n = in.nextLine();
      String[] n_split = n.split(" ");

      int _a_size = Integer.parseInt(n_split[0]);
      int _k = Integer.parseInt(n_split[1]);

      int[] _a = new int[_a_size];
      int _a_item;
      String next = in.nextLine();
      String[] next_split = next.split(" ");

      for (int _a_i = 0; _a_i < _a_size; _a_i++) {
        _a_item = Integer.parseInt(next_split[_a_i]);
        _a[_a_i] = _a_item;

      }

      res = pairs(_a, _k);
      System.out.println(res);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
