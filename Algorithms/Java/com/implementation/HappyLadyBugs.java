// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class HappyLadyBugs {

  static class Solution {

    public static boolean ifHappy(String sequence, int n) {
      boolean fhaveSpace = false;
      boolean happyBugs = true;
      char[] colors = new char[128];
      char c = sequence.charAt(0);
      int validchars = 0;
      if (c != '_') {
        colors[c]++;
        validchars++;
      } else
        fhaveSpace = true;
      for (int i = 1; i < n - 1; i++) {
        c = sequence.charAt(i);
        if (c == '_') {
          fhaveSpace = true;
          continue;
        }

        else if (c != sequence.charAt(i - 1) && c != sequence.charAt(i + 1)) {
          happyBugs = false;
        }
        colors[c]++;
        validchars++;
      }
      if (n > 1) {
        if ((c = sequence.charAt(n - 1)) != '_') {
          colors[c]++;
          validchars++;
          happyBugs = happyBugs && c == sequence.charAt(n - 2);
        } else
          fhaveSpace = true;
      }
      happyBugs = validchars == 0 || (validchars > 1 && happyBugs);
      if (happyBugs) {
        return true;
      } else if (fhaveSpace) {
        happyBugs = true;
        for (int i = 0; i < colors.length; i++) {
          if (colors[i] == 1) {
            happyBugs = false;
            break;
          }
        }
        // if(happyBugs)
        return happyBugs;

      } else {
        return false;
      }

      // return false;

    }

    public static void main(String[] args) {


      Scanner in = new Scanner(System.in);
      int Q = in.nextInt();
      for (int a0 = 0; a0 < Q; a0++) {
        int n = in.nextInt();
        String b = in.next();
        boolean result = ifHappy(b, n);
        if (result)
          System.out.println("YES");
        else
          System.out.println("NO");
      }
      in.close();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
