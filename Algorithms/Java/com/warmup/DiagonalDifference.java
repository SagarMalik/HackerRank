// Author: Sagar Malik
// https://github.com/SagarMalik

package com.warmup;

import java.util.Scanner;

public class DiagonalDifference {
static	class Solution {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int a[][] = new int[n][n];
	        for(int a_i=0; a_i < n; a_i++){
	            for(int a_j=0; a_j < n; a_j++){
	                a[a_i][a_j] = in.nextInt();
	            }
	        }
	        int sum1=0,sum2=0;
	        for(int i=0;i<n;i++)
	        {
	            sum1+=a[i][i];
	            sum2+=a[i][n-i-1];
	        }
	        int sum=sum1>sum2?(sum1-sum2):(sum2-sum1);
	        System.out.println(sum);
	        in.close();
	    }
	}
	
	public static void main(String[] args) {
		Solution.main(args);
	}

}
