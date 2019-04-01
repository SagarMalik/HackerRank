// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class HurdleRace {

	static class Solution {

	    static int hurdleRace(int k, int[] height) {
	       int max=k;
	        for(int a:height)
	           max=max>a?max:a;
	        return max-k;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] height = new int[n];
	        for(int height_i = 0; height_i < n; height_i++){
	            height[height_i] = in.nextInt();
	        }
	        int result = hurdleRace(k, height);
	        System.out.println(result);
	        in.close();
	    }
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
