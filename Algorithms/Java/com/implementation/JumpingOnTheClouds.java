// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

  static class Solution {


    static int jumpingOnClouds(int[] c) {
      int curr = 0, moves = 0, n = c.length;
      while (curr < n - 1) {
        if (curr < n - 2 && c[curr + 2] == 1)
          curr += 1;
        else
          curr += 2;
        moves++;
      }
      return moves;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] c = new int[n];

      String[] cItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int cItem = Integer.parseInt(cItems[i]);
        c[i] = cItem;
      }

      int result = jumpingOnClouds(c);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);
  }
}
