package com.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloydCityOfBlindingLights {

  static class Solution {
    static long[][] edgeMap = null;
    static int n;

    public static void populate() {
      long dist, proposed;
      for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            proposed = edgeMap[i][k] + edgeMap[k][j];
            dist = edgeMap[i][j];
            if (dist > proposed) {
              edgeMap[i][j] = proposed;
            }
          }
        }
      }
    }

    private static final BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
      String[] nm = bufferedReader.readLine().split(" ");

      n = Integer.parseInt(nm[0]);

      int m = Integer.parseInt(nm[1]);



      edgeMap = new long[n][n];
      for (long[] row : edgeMap)
        Arrays.fill(row, Integer.MAX_VALUE);


      for (int i = 0; i < m; i++) {
        String[] edgesRowItems = bufferedReader.readLine().split(" ");
        int src = Integer.parseInt(edgesRowItems[0]) - 1;
        int dest = Integer.parseInt(edgesRowItems[1]) - 1;
        int weight = Integer.parseInt(edgesRowItems[2]);
        edgeMap[src][dest] = weight;
      }

      for (int i = 0; i < n; i++)
        edgeMap[i][i] = 0;
      populate();
      int q = Integer.parseInt(bufferedReader.readLine());

      for (int qItr = 0; qItr < q; qItr++) {
        String[] edgesRowItems = bufferedReader.readLine().split(" ");



        int src = Integer.parseInt(edgesRowItems[0]) - 1;
        int dest = Integer.parseInt(edgesRowItems[1]) - 1;
        if (qItr > 0)
          System.out.println();
        long weight = edgeMap[src][dest];
        if (weight >= Integer.MAX_VALUE)
          weight = -1;
        System.out.print(String.valueOf(weight));
      }

      bufferedReader.close();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
