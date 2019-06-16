// Author: Sagar Malik
// https://github.com/SagarMalik

package com.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickSort1 {

	static class Solution {

	    // Complete the quickSort function below.
	     static int[] quickSort(int[] arr) {
	      int n=arr.length;
	    int []result=new int[n];
	    int startIndex=0;
	    int lastIndex=n-1;
	    int pivot=arr[0];
	    for(int i=0;i<n;i++) {
	        if(arr[i]<pivot) {
	            result[startIndex++]=arr[i];
	        }
	        else if(arr[i]>pivot) {
	            result[lastIndex--]=arr[i];
	        }
	    }
	    for(int i=startIndex;i<=lastIndex;i++)
	    result[i]=pivot;
	    return result;
	     }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] arr = new int[n];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        int[] result = quickSort(arr);

	        for (int i = 0; i < result.length; i++) {
	            bufferedWriter.write(String.valueOf(result[i]));

	            if (i != result.length - 1) {
	                bufferedWriter.write(" ");
	            }
	        }

	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}

	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
