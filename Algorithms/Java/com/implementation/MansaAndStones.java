// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.util.Scanner;

public class MansaAndStones {

	static class Solution {

	    static int[] stones(int n, int a, int b) {
	      int large=a>b?a:b;
	      int small=a+b-large;
	      int diff=large - small ;
	        if (diff==0)
	            return new int[]{(n-1)*large};
	        int []result=new int[n];
	        result[0]=small*(n-1);
	        for(int i=1;i<n;i++){
	            result[i]=result[i-1]+diff;
	        }
	        return result;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int T = in.nextInt();
	        for(int a0 = 0; a0 < T; a0++){
	            int n = in.nextInt();
	            int a = in.nextInt();
	            int b = in.nextInt();
	            int[] result = stones(n, a, b);
	            for (int i = 0; i < result.length; i++) {
	                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
	            }
	            System.out.println("");


	        }
	        in.close();
	    }
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
