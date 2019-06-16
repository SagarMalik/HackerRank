// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class StrangeCode {

  static class Solution {

    static long strangeCode(long t) {
      long bucket = 3;
      while (t > bucket) {
        t -= bucket;
        bucket <<= 1;
      }
      return bucket + 1 - t;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      long t = in.nextLong();
      long result = strangeCode(t);
      System.out.println(result);
      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);
  }

}
