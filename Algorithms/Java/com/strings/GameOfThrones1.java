// Author: Sagar Malik
// https://github.com/SagarMalik


package com.strings;

import java.util.Scanner;

public class GameOfThrones1 {

	static class Solution {
	   public static void main(String[] args) {
	        Scanner myScan = new Scanner(System.in);
	        String inputString = myScan.nextLine();
	       
	        boolean []b=new boolean[26];
	        int  n=inputString.length();
	        int c,count=0;
	        for(int i=0;i<n;i++)
	        {
	            c=inputString.charAt(i)-'a';
	            count+=(b[c]=!b[c])?-1:1;
	            
	        }
	     
	        System.out.println(count>1?"NO":"YES");
	        myScan.close();
	    }
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
