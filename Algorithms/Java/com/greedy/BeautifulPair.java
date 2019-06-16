package com.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BeautifulPair {

  static class Solution {

    // Complete the beautifulPairs function below.
    static int beautifulPairs(int[] A, int[] B) {
      Map<Integer, Integer> a = new HashMap<>();
      Map<Integer, Integer> b = new HashMap<>();
      int bSize = B.length;
      int aSize = A.length;
      int count = 0;

      for (int i : A)
        a.put(i, a.getOrDefault(i, 0) + 1);
      for (int i : B)
        b.put(i, b.getOrDefault(i, 0) + 1);
      Iterator<Integer> iter = a.keySet().iterator();
      while (iter.hasNext() && !b.isEmpty()) {
        int i = iter.next();
        if (b.containsKey(i)) {
          int aCount = a.get(i);
          int bCount = b.get(i);

          b.remove(i);
          iter.remove();
          count += Math.min(aCount, bCount);
        }
      }
      if (aSize == count || count == bSize) {
        if (aSize == count && count == bSize)
          count--;
        return count;
      }
      return count + 1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] A = new int[n];

      String[] AItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int AItem = Integer.parseInt(AItems[i]);
        A[i] = AItem;
      }

      int[] B = new int[n];

      String[] BItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int BItem = Integer.parseInt(BItems[i]);
        B[i] = BItem;
      }

      int result = beautifulPairs(A, B);

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
