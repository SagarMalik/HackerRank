// Author: Sagar Malik
// https://github.com/SagarMalik


package com.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class JimAndTheOrders {

  static class Solution {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
      for (int i = 0; i < orders.length; i++) {
        orders[i][1] += orders[i][0];
        orders[i][0] = i + 1;
      }
      Arrays.sort(orders, (int[] a, int[] b) -> a[1] - b[1]);
      int[] result = new int[orders.length];

      for (int i = 0; i < orders.length; i++) {
        result[i] = orders[i][0];
      }


      return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[][] orders = new int[n][2];

      for (int i = 0; i < n; i++) {
        String[] ordersRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int ordersItem = Integer.parseInt(ordersRowItems[j]);
          orders[i][j] = ordersItem;
        }
      }

      int[] result = jimOrders(orders);

      for (int i = 0; i < result.length; i++) {
        bufferedWriter.write(String.valueOf(result[i]));

        if (i != result.length - 1) {
          bufferedWriter.write(" ");
        }
      }

      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
