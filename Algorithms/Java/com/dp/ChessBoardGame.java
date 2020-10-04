package com.dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class ChessBoardGame {

  static class Solution {
    static final int[][] moves = new int[][] {{2, -1}, {2, 1}, {-1, 2}, {1, 2}};
    static final int[][] chess = new int[15][15];

    // Complete the chessboardGame function below.
    static boolean fVisit(int x, int y) {
      return x > -1 && x < 15 && y > -1 && y < 15 && chess[x][y] == -1;
    }

    static void visit(int x, int y, int curr) {
      chess[x][y] = curr;
      curr = (curr + 1) % 2;
      int newX, newY;
      for (int[] move : moves) {
        newX = x + move[0];
        newY = y + move[1];
        if (fVisit(newX, newY))
          visit(newX, newY, curr);
      }

    }

    static void init() {
      int[][] deadZones = new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 1}};


      for (int[] row : chess)
        Arrays.fill(row, -1);
      int x, y;
      for (int i = 0; i < 15; i++) {
        for (int j = 0; j < 15; j++) {
          boolean possible = false;
          for (int[] move : moves) {
            if (fVisit(i - move[0], j - move[1])) {
              possible = true;
              break;
            }
          }
          if (!possible)
            System.out.println("deadZONE: " + i + " " + j);
        }
      }
      int curr = 1;
      Queue<int[]> queue = new ArrayDeque<>();

      for (int[] deadZone : deadZones) {
        queue.add(deadZone);
      }
      int newX, newY, size;
      while (!queue.isEmpty()) {
        size = queue.size();
        while (size-- > 0) {
          int[] currSpot = queue.poll();
          chess[currSpot[0]][currSpot[1]] = curr;
          for (int[] move : moves) {
            newX = currSpot[0] + move[0];
            newY = currSpot[1] + move[1];
            if (fVisit(newX, newY))
              queue.add(new int[] {newX, newY});

          }
        }
        curr = (curr + 1) % 2;
      }
      for (int[] row : chess)
        System.out.println(Arrays.toString(row));
    }



    static String chessboardGame(int x, int y) {
      x--;
      y--;
      return chess[x][y] == 0 ? "First" : "Second";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      init();
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
        String[] xy = scanner.nextLine().split(" ");

        int x = Integer.parseInt(xy[0]);

        int y = Integer.parseInt(xy[1]);

        String result = chessboardGame(x, y);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
      }

      bufferedWriter.close();

      scanner.close();
    }

  }

  public static void main(String[] args) {
    Solution.init();

  }

}
