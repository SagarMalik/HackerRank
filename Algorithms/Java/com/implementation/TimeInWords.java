// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeInWords {

  static class Solution {
    static String[] units = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve"};
    static String[] tens = {"ten", "twenty"};
    static String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
        "seventeen", "eighten", "nineteen"};
    static String[] quarters = {"quarter", "half"};

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
      String suffix = " past ";
      if (m > 30) {
        m = 60 - m;
        h = (h + 1) % 12;
        suffix = " to ";
      }

      if (m == 0) {
        return units[h - 1] + " o' clock";
      }
      if (m == 15 || m == 30) {
        return (m == 15 ? "quarter" : "half") + suffix + units[h - 1];
      }
      if (m == 1) {
        return "one minute" + suffix + units[h - 1];
      }
      if (m > 10 && m < 20) {
        return teens[m - 11] + " minutes" + suffix + units[h - 1];
      }
      if (m % 10 == 0) {
        return tens[m / 10 - 1] + " minutes" + suffix + units[h - 1];
      }
      if (m < 10) {
        return units[m - 1] + " minutes" + suffix + units[h - 1];
      }
      return "twenty " + units[m - 21] + " minutes" + suffix + units[h - 1];
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int h = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int m = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      String result = timeInWords(h, m);

      bufferedWriter.write(result);
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
    }
  }

  public static void main(String[] args) throws IOException {
    Solution.main(args);

  }

}
