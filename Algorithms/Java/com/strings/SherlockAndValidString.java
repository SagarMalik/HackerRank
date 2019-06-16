// Author: Sagar Malik
// https://github.com/SagarMalik


package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SherlockAndValidString {

  static class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
      int n = s.length(), c;
      int[] chars = new int[26];
      for (int i = 0; i < n; i++) {
        c = s.charAt(i) - 'a';
        chars[c]++;
      }
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for (int i = 0; i < 26; i++) {
        if (chars[i] != 0) {
          map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
      }
      if (map.size() > 2) // more than 2 distinct frequencies
        return "NO";
      if (map.size() == 2) {
        Map.Entry<Integer, Integer> maxEntry = map.lastEntry();
        Map.Entry<Integer, Integer> minEntry = map.firstEntry();
        if (minEntry.getKey() == 1 && minEntry.getValue() == 1) // A single character can be removed
          return "YES";
        if (maxEntry.getValue() > 1 || maxEntry.getKey() - minEntry.getKey() > 1)
          return "NO";
      }
      return "YES"; // single frequency Already

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String s = scanner.nextLine();

      String result = isValid(s);

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
