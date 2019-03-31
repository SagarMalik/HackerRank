// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.util.Scanner;

public class BetweenTwoSets {
static  class Solution {
    static int getTotalX(int[] a, int[] b) {
    	int Gcd=gcd(b);
    	int Lcm=lcm(a);
    	 
    	
    	if(Gcd%Lcm==0)
    	{
    		int count=0;
    		int factor=Gcd/Lcm;
    		for(int i=1;i<=factor;i++)
    			count+=(factor%i==0?1:0);
    		return count;
    	}
    	
        return 0;
    }
    private static int gcd(int a,int b) {
    	int divisor=a>b?b:a;
    	int dividend=a>b?a:b;
        int temp;
    	while(divisor>0) {
    		temp=divisor;
    		divisor=dividend%divisor;
    		dividend=temp;
    	}
    	return dividend;
    }
    private static int gcd(int []arrInt) {
    
        int gcd=arrInt[0];
    	for(int i=1;i<arrInt.length;i++)
    		gcd=gcd(gcd,arrInt[i]);
    	
    	return gcd;
    }
    private static int lcm(int a,int b) 
    {
    	return a*(b/gcd(a,b));
    	
    }
    private static int lcm(int []arrInt) 
    {
    	 int lcm=arrInt[0];
     	for(int i=1;i<arrInt.length;i++)
     		lcm=lcm(lcm,arrInt[i]);
     	
     	return lcm;
    	
    }
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();

	}
}
	public static void main(String[] args) {
		Solution.main(args);

	}

}
