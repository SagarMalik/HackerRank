package com.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountLuck {

  static class Solution {

    static int n, m;
    static char[][] matrix;
    static boolean[][] visited;
    static final int[][] offsets = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean canVisit(int[] point) {
      return reachable(point) && !visited[point[0]][point[1]];
    }

    static boolean reachable(int[] point) {
      int x = point[0], y = point[1];
      return x > -1 && x < n && y > -1 && y < m;
    }

    static int[] getPoint(int[] basePoint, int[] offset) {
      return new int[] {basePoint[0] + offset[0], basePoint[1] + offset[1]};
    }

    static boolean decisionPoint(int[] point) {
      int count = 0;
      int[] newPoint;
      for (int[] offset : offsets) {
        newPoint = getPoint(point, offset);
        if (canVisit(newPoint)) {
          count++;
        }
      }
      return count > 1;
    }

    static boolean isDestination(int[] point) {
      return matrix[point[0]][point[1]] == '*';
    }

    static int dfs(int[] point) {
      if (isDestination(point))
        return 0;

      int[] newPoint;
      int restCount = -1;
      boolean fDecisionPoint = decisionPoint(point);
      visited[point[0]][point[1]] = true;
      search: for (int[] offset : offsets) {
        newPoint = getPoint(point, offset);
        if (canVisit(newPoint)) {
          restCount = dfs(newPoint);
          if (restCount != -1)
            break search;
        }
      }

      if (restCount == -1) {
        return -1;
      }

      if (fDecisionPoint)
        restCount += 1;
      return restCount;
    }

    // Complete the countLuck function below.
    static String countLuck(int k) {
      int[] startPoint = null;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (matrix[i][j] == 'M') {
            startPoint = new int[] {i, j};
          } else
            visited[i][j] = matrix[i][j] == 'X';
        }
      }
      return dfs(startPoint) == k ? "Impressed" : "Oops!";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
        String[] nm = scanner.nextLine().split(" ");

        n = Integer.parseInt(nm[0]);

        m = Integer.parseInt(nm[1]);

        matrix = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
          String matrixItem = scanner.nextLine();
          matrix[i] = matrixItem.toCharArray();
        }

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = countLuck(k);

        bufferedWriter.write(result);
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
