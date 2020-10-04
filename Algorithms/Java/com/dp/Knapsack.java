package com.dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Knapsack {
  static class Solution {
    static int[] mem;

    // Complete the unboundedKnapsack function below.
    static int unboundedKnapsack(int k, int[] arr) {
      if (mem[k] == -1) {

        int possible = 0, remaining, res;
        for (int i = 0; i < arr.length && k >= arr[i]; i++) {
          if (k % arr[i] == 0) {
            possible = k;
            break;
          }
          remaining = k - arr[i];

          res = unboundedKnapsack(remaining, arr);
          possible = Math.max(possible, res + arr[i]);
          if (possible == k) {
            break;
          }

        }
        mem[k] = possible;
      }
      return mem[k];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = scanner.nextInt();
      while (t-- > 0) {
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
          int arrItem = Integer.parseInt(arrItems[i]);
          if (set.add(arrItem))
            arr[set.size() - 1] = arrItem;
        }
        arr = Arrays.copyOf(arr, set.size());
        set.clear();
        Arrays.sort(arr);
        mem = new int[k + 1];

        Arrays.fill(mem, -1);
        mem[0] = 0;
        int result = unboundedKnapsack(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      }

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
