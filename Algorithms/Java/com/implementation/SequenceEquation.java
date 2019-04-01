// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.util.Scanner;

public class SequenceEquation {

	static class Solution {

	    static int[] permutationEquation(int[] p) {
	      int []k=new int[p.length];
	        for(int i:p)
	            k[p[p[i-1]-1]-1]=i;
	        return k;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] p = new int[n];
	        for(int p_i = 0; p_i < n; p_i++){
	            p[p_i] = in.nextInt();
	        }
	        int[] result = permutationEquation(p);
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
