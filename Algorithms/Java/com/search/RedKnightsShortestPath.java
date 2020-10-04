package com.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RedKnightsShortestPath {

  static class Solution {
    static class TrackerPoint {
      int x, y, order;
      String path;
      static int xFinal, yFinal;

      static void setDestination(int x1, int y1) {
        xFinal = x1;
        yFinal = y1;
      }

      public boolean isDestination() {
        return x == xFinal && y == yFinal;
      }

      public TrackerPoint(int x, int y, int order) {
        this.x = x;
        this.y = y;
        this.order = order;
      }

      public void setPath(String path) {
        this.path = path;
      }

      public void visit() {
        visited[x][y] = true;
      }

      public List<TrackerPoint> getPossibleMoves() {
        List<TrackerPoint> pts = new ArrayList<>();
        TrackerPoint pt;
        for (int i = 0; i < offsets.length; i++) {
          pt = getPoint(this, offsets[i]);
          if (canVisit(pt)) {
            pt.setPath(path + " " + offsetsDesc[i]);
            pts.add(pt);
            pt.visit();
          }
        }
        return pts;
      }


    }

    static final int[][] offsets =
        new int[][] {{-2, -1}, {-2, 1}, {0, 2}, {2, 1}, {2, -1}, {0, -2}};
    static final String[] offsetsDesc = new String[] {"UL", "UR", "R", "LR", "LL", "L"};
    static boolean[][] visited;
    static int n;

    static boolean canVisit(TrackerPoint pt) {
      int x = pt.x, y = pt.y;
      return x > -1 && x < n && y > -1 && y < n && !visited[x][y];
    }


    static TrackerPoint getPoint(TrackerPoint pt, int[] offset) {
      return new TrackerPoint(pt.x + offset[0], pt.y + offset[1], pt.order + 1);
    }

    // Complete the printShortestPath function below.
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
      TrackerPoint startPoint = new TrackerPoint(i_start, j_start, 0);
      startPoint.setPath("");
      TrackerPoint.setDestination(i_end, j_end);
      Queue<TrackerPoint> queue = new ArrayDeque<>();
      queue.add(startPoint);
      startPoint.visit();
      while (!queue.isEmpty()) {
        TrackerPoint tp = queue.poll();
        if (tp.isDestination()) {
          System.out.println(tp.order + "\n" + tp.path.trim());
          return;
        }

        // System.out.println("Visited " + tp.x + " " + tp.y);
        List<TrackerPoint> nextPoints = tp.getPossibleMoves();
        for (TrackerPoint p : nextPoints) {
          queue.add(p);
          p.visit();
        }


      }
      System.out.println("Impossible");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      visited = new boolean[n][n];
      String[] i_startJ_start = scanner.nextLine().split(" ");

      int i_start = Integer.parseInt(i_startJ_start[0]);

      int j_start = Integer.parseInt(i_startJ_start[1]);

      int i_end = Integer.parseInt(i_startJ_start[2]);

      int j_end = Integer.parseInt(i_startJ_start[3]);


      printShortestPath(n, i_start, j_start, i_end, j_end);

      scanner.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
