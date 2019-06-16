// Author: Sagar Malik
// https://github.com/SagarMalik


package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {

  static class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
      int count = 0, len = s.length();
      Map<String, Integer> map = new HashMap<>();
      String stCompressed;
      for (int i = 0; i < len; i++) {
        for (int j = i + 1; j <= len; j++) {
          stCompressed = getCompressedAnagram(s.substring(i, j));
          count = map.getOrDefault(stCompressed, 0);
          map.put(stCompressed, count + 1);
        }
      }
      count = 0;
      for (Integer val : map.values())
        count += (val * (val - 1)) / 2;

      return count;
    }

    private static String getCompressedAnagram(String st) {
      int[] charCt = new int[26];
      char c;
      for (int i = 0; i < st.length(); i++) {
        c = st.charAt(i);
        charCt[(int) c - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        if (charCt[i] > 0)
          sb.append((char) (i + 'a')).append(charCt[i]);
      }
      return sb.toString();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int q = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int qItr = 0; qItr < q; qItr++) {
        String s = scanner.nextLine();

        int result = sherlockAndAnagrams(s);

        bufferedWriter.write(String.valueOf(result));
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
