// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StringConstruction {

	static class Solution {

	    // Complete the stringConstruction function below.
		static int stringConstruction(String s) {
			boolean []isPresent=new boolean[26];
			int cost=0;
			int j,n1=s.length();
			for(int i=0;i<n1;i++){
				j=s.charAt(i)-'a';
				if(!isPresent[j]) {
					cost++;
					isPresent[j]=true;
					if(cost==26)
						break;
				}
			}
			return cost;
		}

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int q = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int qItr = 0; qItr < q; qItr++) {
	            String s = scanner.nextLine();

	            int result = stringConstruction(s);

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
