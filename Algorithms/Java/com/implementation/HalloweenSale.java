// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HalloweenSale {

  static class Solution {

    static int howManyGames(int p, int d, int m, int s) {
      // Return the number of games you can buy
      int games = 0, current = p;
      while (s >= current) {
        games++;
        s -= current;
        current = current - d > m ? current - d : m;
      }
      return games;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] pdms = scanner.nextLine().split(" ");

      int p = Integer.parseInt(pdms[0]);

      int d = Integer.parseInt(pdms[1]);

      int m = Integer.parseInt(pdms[2]);

      int s = Integer.parseInt(pdms[3]);

      int answer = howManyGames(p, d, m, s);

      bufferedWriter.write(String.valueOf(answer));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
