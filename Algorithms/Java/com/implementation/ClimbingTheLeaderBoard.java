// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class ClimbingTheLeaderBoard {

  static class Solution {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
      int lowest = alice[0];
      int curr = scores[0];
      int n = alice.length;
      int[] ranks = new int[n];

      int j = 0;
      if (curr == lowest)
        j = -1;
      else {
        for (int k = 1; k < scores.length && scores[k] > lowest; k++) {
          if (scores[k] != curr) {
            curr = scores[k];
            scores[++j] = curr;
          }

        }
      }
      int l = 0;
      ranks[l++] = j + 2;

      for (; l < n && j >= 0; l++) {
        while (j >= 0 && scores[j] <= alice[l]) {
          j--;
        }
        ranks[l] = j + 2;
      }
      for (; l < n; l++)
        ranks[l] = j + 2;
      return ranks;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] scores = new int[n];
      for (int scores_i = 0; scores_i < n; scores_i++) {
        scores[scores_i] = in.nextInt();
      }
      int m = in.nextInt();
      int[] alice = new int[m];
      for (int alice_i = 0; alice_i < m; alice_i++) {
        alice[alice_i] = in.nextInt();
      }
      int[] result = climbingLeaderboard(scores, alice);
      for (int i = 0; i < result.length; i++) {
        System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
      }
      System.out.println("");


      in.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
