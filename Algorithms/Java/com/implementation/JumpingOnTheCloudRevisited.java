package com.implementation;

import java.util.Scanner;

public class JumpingOnTheCloudRevisited {

	static  class Solution {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int c[] = new int[n];
	        for(int c_i=0; c_i < n; c_i++){
	            c[c_i] = in.nextInt();
	        }
	        boolean first=true;
	        int curr=0;
	        int energy=100;
	        while (curr!=0 || first)
	        {
	            curr=(curr+k)%n;
	            energy-=(1+c[curr]*2);
	            first=false;
	        }
	        System.out.println(energy);
	        in.close();
	    }
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
