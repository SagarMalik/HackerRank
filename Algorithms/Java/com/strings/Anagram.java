// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Anagram {

	static class Solution {

	    // Complete the anagram function below.
	    static int anagram(String s) {
	      int n=s.length();
	      if(n%2==1)
	          return -1;
	    
	      int mid=n/2,i=0;    
	      int []chars=new int[26];
	      for(;i<mid;i++) chars[s.charAt(i)-'a']++; 
	      for(;i<n;i++)   chars[s.charAt(i)-'a']--;
	      int changes=0;
	      for(i=0;i<chars.length;i++) changes+=Math.abs(chars[i]); 
	        return changes/2;

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int q = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int qItr = 0; qItr < q; qItr++) {
	            String s = scanner.nextLine();

	            int result = anagram(s);

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
