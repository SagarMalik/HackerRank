package com.constructivealgo;

import static java.util.stream.Collectors.toList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GamingArray {

  static class Result {
    static String[] players = new String[] {"ANDY", "BOB"};
    /*
     * Complete the 'gamingArray' function below.
     *
     * The function is expected to return a STRING. The function accepts INTEGER_ARRAY arr as
     * parameter.
     */

    public static String gamingArray(List<Integer> arr) {
      // Write your code here

      int n = arr.size() - 1;
      Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

      for (int i = n; i > -1; i--) {
        map.put(arr.get(i), i);
      }
      int min = Integer.MAX_VALUE, pivots = 0;

      for (Map.Entry<Integer, Integer> en : map.entrySet()) {
        if (min > en.getValue()) {
          pivots++;
          min = en.getValue();
        }
      }
      return players[pivots % 2];
    }

  }

  static class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int g = Integer.parseInt(bufferedReader.readLine().trim());

      IntStream.range(0, g).forEach(gItr -> {
        try {
          int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

          List<Integer> arr =
              Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                  .map(Integer::parseInt).collect(toList());

          String result = Result.gamingArray(arr);

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
