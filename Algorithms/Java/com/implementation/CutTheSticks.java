// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.util.Scanner;

public class CutTheSticks {

	static  class Solution {

	    static int[] cutTheSticks(int[] arr) {
	       int []sticks=new int[1001];
		       int []result=new int[1001];
		        int idx=0;
		        int total=arr.length;
		        result[idx++]=total;
		        int min=arr[0];
		       int max=arr[0];
		        for(int i:arr){
		            min=min<i?min:i;
		            max=max>i?max:i;
		            sticks[i]++;
		        }int i=0;
		        while(min>0){
		        	total-=sticks[min];
		            if (total==0) break;
		        	result[idx++]=total;
		            sticks[min]=0;
		            max-=min;
		            System.arraycopy(sticks, min, sticks, 0, max+1);
		            i=0;
		            while(sticks[++i]==0 && i<max) {}
		             min=i;
		            
		        }
		        int []actualResult=new int[idx];
		        
		        System.arraycopy(result, 0, actualResult, 0, idx);
		        
		        
		        
		      return actualResult;  
	        
	    }
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for(int arr_i = 0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }
	        int[] result = cutTheSticks(arr);
	        for (int i = 0; i < result.length; i++) {
	            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
	        }
	        System.out.println("");


	        in.close();
	    }
	}

	
	public static void main(String[] args) {
		Solution.main(args);

	}

}
