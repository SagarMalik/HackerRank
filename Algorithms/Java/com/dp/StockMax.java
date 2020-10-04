// Author: Sagar Malik
// https://github.com/SagarMalik


package com.dp;

import static java.util.stream.Collectors.toList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StockMax {

  static class Result {

    /*
     * Complete the 'stockmax' function below.
     *
     * The function is expected to return a LONG_INTEGER. The function accepts INTEGER_ARRAY prices
     * as parameter.
     */

    public static long stockmax(List<Integer> prices) {

      int len = prices.size();
      int max = prices.get(--len), elem;
      long profit = 0;
      for (int i = len; i >= 0; i--) {
        elem = prices.get(i);
        if (elem > max)
          max = elem;
        else
          profit += (max - elem);
      }
      return profit;

    }
  }
  static class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = Integer.parseInt(bufferedReader.readLine().trim());

      IntStream.range(0, t).forEach(tItr -> {
        try {
          // int n = Integer.parseInt(bufferedReader.readLine().trim());

          List<Integer> prices =
              Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                  .map(Integer::parseInt).collect(toList());

          long result = Result.stockmax(prices);

          bufferedWriter.write(String.valueOf(result));
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
