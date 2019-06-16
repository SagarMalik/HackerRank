// Author: Sagar Malik
// https://github.com/SagarMalik


package com.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BigSorting {

	static class Solution {

	    // Complete the bigSorting function below.
	    static String[] bigSorting(String[] unsorted) {
	    Arrays.sort(unsorted,(String st1,String st2)->{
	        return st1.length()>st2.length() ? 1 :st1.length()<st2.length()? -1 : st1.compareTo(st2);
	    });
	return unsorted;
	    }

	     // private static final Scanner scanner = new Scanner(System.in);
	    private static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = Integer.valueOf(br.readLine()); //scanner.nextInt();
	       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        String[] unsorted = new String[n];

	        for (int i = 0; i < n; i++) {
	            String unsortedItem = br.readLine();
	            unsorted[i] = unsortedItem;
	        }

	      //  String[] result = bigSorting(unsorted);
	 Arrays.parallelSort(unsorted,(String st1,String st2)->{
	         int len1=st1.length();
	         int len2=st2.length();
	        return len1>len2 ? 1 :len1<len2? -1 : st1.compareTo(st2);
	    });

	        for (int i = 0; i < unsorted.length; i++) {
	            bufferedWriter.write(unsorted[i]);

	            if (i != unsorted.length - 1) {
	                bufferedWriter.write("\n");
	            }
	        }

	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        br.close();
	    }
	}

	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
