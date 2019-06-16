// Author: Sagar Malik
// https://github.com/SagarMalik


package com.search;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MissingNumbers {

  static class Solution {

    public static void main(String[] args) {
      /*
       * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
       * named Solution.
       */
      Scanner sc = new Scanner(System.in);
      Map<Integer, Integer> A = new TreeMap<Integer, Integer>();
      Map<Integer, Integer> B = new TreeMap<Integer, Integer>();
      int count, num;
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        num = sc.nextInt();
        count = 1;
        if (A.containsKey(num))
          count += A.get(num);
        A.put(num, count);


      }
      int m = sc.nextInt();
      for (int i = 0; i < m; i++) {
        num = sc.nextInt();
        count = 1;
        if (B.containsKey(num))
          count += B.get(num);
        B.put(num, count);


      }
      int key, val;
      for (Map.Entry<Integer, Integer> entry : A.entrySet()) {
        key = entry.getKey();
        val = entry.getValue();
        if (!B.containsKey(key) || B.get(key) != val)
          System.out.print(key + " ");



      }
      sc.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
