package com.dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RedJohnIsBack {

  static class Solution {

    public static long npr(int n, int r) {
      long prod = 1;
      for (int i = 0; i < r; i++)
        prod *= (n - i);
      return prod;
    }

    public static int ncr(int n, int r) {
      return (int) (npr(n, r) / npr(r, r));
    }

    public static int[] generatePrimesSeiveEratos(int limit) {
      boolean[] sieve = new boolean[limit + 1];
      int crosslimit = (int) Math.ceil(Math.sqrt(limit));
      ArrayList<Integer> list = new ArrayList<>();
      list.add(2);
      for (int i = 3; i <= crosslimit; i += 2) {
        if (!sieve[i]) {
          for (int j = i * i; j <= limit; j += i) {
            sieve[j] = true;
          }
        }
      }

      for (int i = 3; i <= limit; i += 2) {
        if (!sieve[i])
          list.add(i);
      }
      int[] nums = new int[list.size()];
      for (int i = 0; i < nums.length; i++) {
        nums[i] = list.get(i);
      }
      return nums;
    }

    public static int[] primes = generatePrimesSeiveEratos(217286);
    public static int[] solutions = populate();

    public static int[] populate() {
      int[] arr = new int[41];
      for (int i = 0; i < 41; i++)
        arr[i] = redJohn(i);
      return arr;
    }

    // Complete the redJohn function below.
    static int findArrangement(int n) {
      if (n < 3)
        return 1;
      int pack = n / 4;
      int verticals = n % 4;
      int total_places = pack + verticals;
      int result = 1;
      while (pack > 0) {

        result += ncr(total_places, pack);
        total_places += 3;
        pack -= 1;
      }
      return result;
    }

    static int redJohn(int n) {

      int k = findArrangement(n);
      // System.err.println("Arrangement for " + n + " : " + k);
      int i = Arrays.binarySearch(primes, k);
      return i > -1 ? i + 1 : -i - 1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = solutions[n];

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
