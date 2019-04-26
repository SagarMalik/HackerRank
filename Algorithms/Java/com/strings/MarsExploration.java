// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarsExploration {

	static class Solution {
		public static final char[] SOS="SOS".toCharArray();

	    // Complete the marsExploration function below.
	    static int marsExploration(String s) {
	    int n=s.length(),count=0;
	  	for(int i=0;i<n;i++){
	      if(s.charAt(i)!=SOS[i%3])
	      count++;
	    }
	    return count;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String s = scanner.nextLine();

	        int result = marsExploration(s);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}

	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}


}
