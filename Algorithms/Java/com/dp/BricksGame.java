package com.dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BricksGame {

  static class Solution {
    /*
     * Complete the bricksGame function below.
     */

    static long bricksGame(int[] arr) {
      long[] sol = new long[arr.length];
      int i = arr.length - 1;
      long sum = 0;
      for (; i > -1 && i > arr.length - 4; i--) {
        sum += arr[i];
        sol[i] = sum;
      }
      for (; i > -1; i--) {
        sum += arr[i];
        sol[i] = sum - Math.min(sol[i + 3], Math.min(sol[i + 1], sol[i + 2]));;
      }

      return sol[0];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = Integer.parseInt(scanner.nextLine().trim());

      for (int tItr = 0; tItr < t; tItr++) {
        int arrCount = Integer.parseInt(scanner.nextLine().trim());

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
          int arrItem = Integer.parseInt(arrItems[arrItr].trim());
          arr[arrItr] = arrItem;
        }

        long result = bricksGame(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      }

      bufferedWriter.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
