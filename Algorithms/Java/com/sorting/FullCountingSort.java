package com.sorting;

import java.util.Scanner;

public class FullCountingSort {

	static class  Solution {

	    public static void main(String[] args) {
	       Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        StringBuilder []arrSb=new StringBuilder[100];
	        for(int a0 = 0; a0 < n; a0++){
	            int x = in.nextInt();
	            String s = in.next();
	            if (a0<n/2)
	            	s="-";
	            if(arrSb[x]==null) {
	            	arrSb[x]=new StringBuilder();
	                arrSb[x].append(s);
	             }
	            else
	            	  arrSb[x].append(" ").append(s);
	            
	            }
	        for(int i=0;i<arrSb.length;i++) 
	        {
	        	if(arrSb[i]!=null)
	        		System.out.print(arrSb[i].toString() + (i != arrSb.length - 1 ? " " : ""));
	        	
	        	
	        }
	        in.close();
	    }
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
