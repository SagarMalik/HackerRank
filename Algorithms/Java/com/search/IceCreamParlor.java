// Author: Sagar Malik
// https://github.com/SagarMalik


package com.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class IceCreamParlor {

	static class Solution {

	    // Complete the icecreamParlor function below.
	    static int[] icecreamParlor(int m, int[] arr) {
	          int[][] arr2 = new int[arr.length][2];
	          for(int i=0;i<arr.length;i++) {
	              arr2[i][0]=arr[i];
	              arr2[i][1]=i+1;
	          }
	          int j;
	          Arrays.sort(arr2,(int[]a , int []b)->a[0]-b[0]);
	          Arrays.sort(arr);
	          for(int i=0;i<arr.length;i++) {
	          j=    Arrays.binarySearch(arr, m-arr[i]);
	          if(j>=i) {
	              if(j==i)
	                  j++;
	                    int []result=new int[2];
	              result[0]=arr2[i][1];
	              result[1]=arr2[j][1];
	              Arrays.sort(result);
	              return result;
	              
	              
	          }
	          }
	    return null;

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            int m = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int n = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int[] arr = new int[n];

	            String[] arrItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int i = 0; i < n; i++) {
	                int arrItem = Integer.parseInt(arrItems[i]);
	                arr[i] = arrItem;
	            }

	            int[] result = icecreamParlor(m, arr);

	            for (int i = 0; i < result.length; i++) {
	                bufferedWriter.write(String.valueOf(result[i]));

	                if (i != result.length - 1) {
	                    bufferedWriter.write(" ");
	                }
	            }

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
