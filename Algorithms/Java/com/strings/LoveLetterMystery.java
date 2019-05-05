// Author: Sagar Malik
// https://github.com/SagarMalik
package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoveLetterMystery {
static class Solution {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
      int count=0,l=0,r=s.length()-1;
      while(l<r)
      count+=Math.abs(s.charAt(l++)-s.charAt(r--));
    return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

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
