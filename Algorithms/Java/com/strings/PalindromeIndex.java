// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PalindromeIndex {

  static class Solution {
    // checking if palindrome possible starting from left and right index
    static boolean chk(char[] chars, int l, int r) {
      while (l < r) {
        if (chars[l++] != chars[r--])
          return false;
      }
      return true;
    }

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
      char[] chars = s.toCharArray();
      int l = -1, r = chars.length;
      while (l < r) {
        if (chars[++l] != chars[--r])
          break;
      }
      if (l == r) // Odd Length Palindrome , remove the middle character
        return l;
      else if (l > r) // Even Length Palindrome , no solution
        return -1;
      return chk(chars, l + 1, r) ? l : chk(chars, l, r - 1) ? r : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int q = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int qItr = 0; qItr < q; qItr++) {
        String s = scanner.nextLine();

        int result = palindromeIndex(s);

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
