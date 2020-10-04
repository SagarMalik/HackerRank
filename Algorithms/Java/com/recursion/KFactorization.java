package com.recursion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KFactorization {

  static class Solution {
    static int min_len = 30;
    static ArrayList<ArrayList<Integer>> allFactorsList;


    static void factorize(int n, int[] A, int idx, List<Integer> prev) {
      if (idx == -1 || prev.size() >= min_len) {
        // Exhausted all numbers or already smaller solution present
        return;
      }
      if (n % A[idx] == 0) {
        ArrayList<Integer> local = new ArrayList<>(prev);
        int n2 = n, sz = local.size();

        local.add(A[idx]);
        sz++;
        n2 /= A[idx];
        if (n2 == 1) {
          // we have hit one of the possible solution
          if (sz < min_len) {
            allFactorsList.clear();
            min_len = sz;
          }
          allFactorsList.add(local);
        } else if (sz < min_len) {
          // Recursive call allowing the current number
          factorize(n2, A, idx, local);
        }
      }
      // Not include the current number at all
      factorize(n, A, idx - 1, prev);
    }

    static ArrayList<Integer> kFactorization(int n, int[] A) {
      allFactorsList = new ArrayList<ArrayList<Integer>>();
      factorize(n, A, A.length - 1, new ArrayList<Integer>());
      ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
      for (ArrayList<Integer> list : allFactorsList) {
        finalList.add(transform(list));
      }
      Collections.sort(finalList, (list1, list2) -> {
        return compare(list1, list2);
      });

      return finalList.size() > 0 ? finalList.get(0) : new ArrayList<>();

    }


    public static int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
      int sz = list1.size(), first, second;
      for (int i = 0; i < sz; i++) {
        first = list1.get(i);
        second = list2.get(i);
        if (first != second)
          return Integer.compare(first, second);
      }
      return 0;
    }

    public static ArrayList<Integer> transform(ArrayList<Integer> list) {
      Collections.sort(list);
      int cumul = 1;
      ArrayList<Integer> result = new ArrayList<>();
      result.add(cumul);
      for (Integer i : list) {
        cumul *= i;
        result.add(cumul);

      }
      return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] nk = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nk[0]);
      int k = Integer.parseInt(nk[1]);

      int[] A = new int[k];

      String[] AItems = scanner.nextLine().split(" ");
      // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int idx = 0;
      for (int i = 0; i < k; i++) {
        int AItem = Integer.parseInt(AItems[i]);
        if (n % AItem == 0 && AItem != 1)
          A[idx++] = AItem;
      }
      A = Arrays.copyOf(A, idx);
      Arrays.sort(A);

      ArrayList<Integer> result = kFactorization(n, A);
      if (result.size() > 0) {
        for (int i = 0; i < result.size(); i++) {
          bufferedWriter.write(String.valueOf(result.get(i)));

          if (i != result.size() - 1) {
            bufferedWriter.write(" ");
          }
        }
      } else {
        bufferedWriter.write(String.valueOf(-1));
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
