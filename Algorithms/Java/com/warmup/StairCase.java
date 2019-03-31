// Author: Sagar Malik
// https://github.com/SagarMalik

package com.warmup;

import java.util.Scanner;

public class StairCase {
	static class Solution {
		public static String repeat(String st,int n)
		{
			StringBuilder sb=new StringBuilder();
			while(n-->0)sb.append(st);
			return sb.toString();
		}

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int i=1;
			while(i<=n)  
			{
				System.out.println(repeat(" ",n-i)+repeat("#",i));
				i++;  
			}
			in.close();
		}
	}
	public static void main(String[] args) {
		Solution.main(args);

	}

}
