// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class TaumAndBday {

	static  class Solution {

	    static long taumBday(int b, int w, int x, int y, int z) {
	       if (x>y) 
	    	   x=Math.max(x, y+z);
	        else  
	        	y=Math.max(y, x+z);
	        long total=b*(long)x;
	        total+=y*(long)w;
	        
	        return total;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int b = in.nextInt();
	            int w = in.nextInt();
	            int x = in.nextInt();
	            int y = in.nextInt();
	            int z = in.nextInt();
	            long result = taumBday(b, w, x, y, z);
	            System.out.println(result);
	        }
	        in.close();
	    }
	}

	public static void main(String[] args) {
	Solution.main(args);

	}

}
