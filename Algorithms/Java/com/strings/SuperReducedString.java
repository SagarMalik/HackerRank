// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class SuperReducedString {

	static class Solution {

	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	    Scanner sc=new Scanner(System.in);
			        String st=sc.next();
			        Stack<Character> cs=new Stack<>();
			        for(char c:st.toCharArray()){
			            if (!cs.isEmpty()  && cs.peek().equals(c))
			            	cs.pop();
			            else
			            	cs.push(c);
			        }
			        if (cs.isEmpty())
			        	System.out.println("Empty String");
			        else
			        	{
			        	int n=cs.size();
			        	char []ca=new char[n];
	                    n=0;
			        	Iterator<Character> it=cs.iterator();
			        	
			        	while (it.hasNext())
			        		ca[n++]=it.next();
			        	System.out.println(String.valueOf(ca));
			        	}
			        sc.close();
			        
	    }
	}
	public static void main(String[] args) {
	Solution.main(args);
	}

}
