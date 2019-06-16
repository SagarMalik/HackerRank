// Author: Sagar Malik
// https://github.com/SagarMalik

package com.sorting;

import java.util.Scanner;

public class InsertionSort1 {

	static class Solution {

	    // Complete the insertionSort1 function below.
	    static void insertionSort1(int n, int[] arr) {
	      int lastNum=arr[arr.length-1];
	      int i=0;
	      while(arr[i]<=lastNum){
	        i++;
	      }
	      
	     int j=arr.length-2;
	      while(j>=i){
	          arr[j+1]=arr[j--];
	          printArray(arr);
	      }
	        arr[i]=lastNum;
	        printArray(arr);


	    }
	    static void printArray(int []arr){
	        System.out.print(arr[0]);
	        for(int i=1;i<arr.length;i++)
	          System.out.print(" "+arr[i]);
	          System.out.println();


	    }
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] arr = new int[n];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        insertionSort1(n, arr);

	        scanner.close();
	    }
	}

	public static void main(String[] args) {
		
		Solution.main(args);
	}

}
