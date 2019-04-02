// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindDigits {

	static  class Solution {
	    static int findDigits(int n) {
	      int []digits=new int[10];
	      int n2=n;
	      while(n2>0){
	        digits[n2%10]++;
	        n2/=10;
	      }
	    int sum=0;
	    for(int i=1;i<10;i++){
	      if(digits[i]>0 && n%i==0)
	      sum+=digits[i];
	      
	    }
	    return sum;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            int n = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int result = findDigits(n);

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
