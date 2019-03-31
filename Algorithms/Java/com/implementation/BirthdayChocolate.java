// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class BirthdayChocolate {
static  class Solution {

    static int solve(int n, int[] s, int d, int m){
      if(n<m)
          return 0;
      int sum=0,count=0; 
      for(int i=0;i<m;i++)
          sum+=s[i];
       count+=(d==sum?1:0);
        for(int i=m;i<n;i++){
            sum+=(s[i]-s[i-m]);
            count+=(d==sum?1:0);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
        in.close();
    }
}
	
	public static void main(String[] args) {
		Solution.main(args);
}
}
