// Author: Sagar Malik
// https://github.com/SagarMalik

package com.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class SherlockAndBeast {

  static class Solution {

    // Complete the decentNumber function below.
    static void decentNumber(int n) {

      int fives = n, threes = 0;
      while (fives >= 0 && fives % 3 != 0) {
        fives -= 5;
        threes += 5;
      }
      if (fives >= 0 && fives % 3 == 0) {

        for (int i = 0; i < fives; i++)
          System.out.print('5');
        for (int i = 0; i < threes; i++)
          System.out.print('3');
        System.out.println();
        return;
      } else {
        System.out.println("-1");
        return;
      }
    }

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      int t = Integer.parseInt(bufferedReader.readLine().trim());

      IntStream.range(0, t).forEach(tItr -> {
        try {
          int n = Integer.parseInt(bufferedReader.readLine().trim());

          decentNumber(n);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      });

      bufferedReader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
