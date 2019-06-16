// Author: Sagar Malik
// https://github.com/SagarMalik

package com.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class SherlockAndArray {

  static class Solution {

    // Complete the balancedSums function below.
    static String balancedSums(int[] arr, int[] arrLeftSum) {
      int n = arr.length;
      int j = 0;
      int[] arrRightSum = new int[n];
      for (int i = 0; i < n; i++) {
        j = n - 1 - i;
        if (i > 0) {
          arrRightSum[j] += arr[j + 1] + arrRightSum[j + 1];
          if (arrRightSum[j] == arrLeftSum[j])
            return "YES";
        }

      }
      return "NO";
    }

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int T = Integer.parseInt(bufferedReader.readLine().trim());

      IntStream.range(0, T).forEach(TItr -> {
        try {
          int n = Integer.parseInt(bufferedReader.readLine().trim());
          String result;

          int[] arr = new int[n];
          int[] arrLeftSum = new int[n];
          String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
          if (arrItems.length != n) {
            System.err.println("Hacker Rank needs more proof reading n=" + n + " given array count "
                + arrItems.length);
            n = arrItems.length;
            arr = new int[n];
          }
          if (n == 1) {
            result = "YES";
          } else {
            for (int i = 0; i < n; i++) {
              int arrItem = Integer.parseInt(arrItems[i]);
              arr[i] = arrItem;
              if (i > 0)
                arrLeftSum[i] = arr[i - 1] + arrLeftSum[i - 1];
            }

            result = balancedSums(arr, arrLeftSum);
          }
          bufferedWriter.write(result);
          bufferedWriter.newLine();
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      });

      bufferedReader.close();
      bufferedWriter.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
