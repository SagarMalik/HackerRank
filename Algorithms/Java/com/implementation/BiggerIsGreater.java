// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsGreater {

	static class Solution {
		public static String LexSuccesor(String t)
		{
			int l=t.length()-1;
			// System.out.println("String "+t+" length "+l);
			char []chars=t.toCharArray();
			while(l>0 && chars[l]<=chars[l-1] )
			{
				l--;        
			}
			if (l==0)
			{
				return "no answer";

			}
			char c=chars[l-1];
			int pos=-1;
			char minchar='z';
			for(int i=l;i<chars.length;i++)
			{
				if(chars[i]>c && chars[i]<=minchar)
				{
					minchar=chars[i];
					pos=i;

				}


			}
			chars[l-1]=minchar;
			chars[pos]=c;
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<l;i++)
				sb.append(chars[i]);
			char []chars2=new char[chars.length-l];
			for(int i=0;i<chars.length-l;i++)
				chars2[i]=chars[i+l];
			Arrays.sort(chars2);
			for(int i=0;i<chars2.length;i++)
				sb.append(chars2[i]);

			return sb.toString();


		}
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int q=sc.nextInt();
			String st;
			while(q-->0)
			{
				st=sc.next();
				System.out.println(LexSuccesor(st));
			}
			sc.close();
		}
	}
	public static void main(String[] args) {
		Solution.main(args);

	}

}
