// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class AppendAndDelete {

	static class Solution {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        String t = in.next();
	        int k = in.nextInt();
	        int l_s=s.length();
	        int l_t=t.length();
	        int j=0;
	        while(j<l_s && j < l_t && s.charAt(j)==t.charAt(j)){j++;}
	        if(((l_s+l_t-2*j-k)<=0 && (l_s+l_t-2*j-k)%2==0)||l_s+l_t<=k)
	            System.out.println("Yes");
	        else
	            System.out.println("No");
	        in.close();
	    }
	}
	
	public static void main(String[] args) {
		Solution.main(args);

	}

}
