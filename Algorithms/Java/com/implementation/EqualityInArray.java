// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualityInArray {

  static class Solution {

    static int equalizeArray(int[] arr) {
      int max = 0, v = 0;
      Map<Integer, Integer> keeper = new HashMap<>();
      for (int num : arr) {
        v = keeper.getOrDefault(num, 0) + 1;
        keeper.put(num, v);
        max = Math.max(max, v);
      }
      return arr.length - max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] arr = new int[n];

      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
      }

      int result = equalizeArray(arr);

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
