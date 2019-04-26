// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.util.Scanner;

public class HackerRankInString {

	static  class Solution {
		static char []hackerRank="hackerrank".toCharArray();
		static int HLEN=hackerRank.length;    
		static String hackerrankInString(String s) {
			int len=s.length(),idx=0;
			if(len<HLEN)
				return "NO";
			for(int i=0;i<len && len-i>=HLEN-idx;i++){
				if(s.charAt(i)==hackerRank[idx])
				{
					idx++;
					if (idx==HLEN)
						return "YES";
				}
			}
			return "NO";
		}

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int q = in.nextInt();
			for(int a0 = 0; a0 < q; a0++){
				String s = in.next();
				String result = hackerrankInString(s);
				System.out.println(result);
			}
			in.close();
		}
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
