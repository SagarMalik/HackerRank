// Author: Sagar Malik
// https://github.com/SagarMalik

package com.sorting;

import java.util.Scanner;

public class CorrectnessLoopInvariant {

	static class Solution {

	    public static void insertionSort(int[] A){
	        for(int i = 1; i < A.length; i++){
	            int value = A[i];
	            for(int j=0;j<i;j++){
	                  if (A[j]>value){  // found position
	                  System.arraycopy(A,j,A,j+1,i-j);
	                  A[j]=value;
	                      break;
	                  }
	              }
	        }

	        printArray(A);
	    }


	    static void printArray(int[] ar) {
	        for(int n: ar){
	            System.out.print(n+" ");
	        }
	    }
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] ar = new int[n];
	        for(int i=0;i<n;i++){
	            ar[i]=in.nextInt();
	        }
	        in.close();
	        insertionSort(ar);
	    }
	}


	public static void main(String[] args) {
		Solution.main(args);

	}

}
