// Author: Sagar Malik
// https://github.com/SagarMalik


package com.warmup;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TimeConversion {

	static class Solution {

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			String time = in.next();
			SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ssa");
			SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
			in.close();
			try{
				System.out.println(sdf2.format(sdf1.parse(time)));

			} catch(Exception e){

			}
		}
	}

	public static void main(String[] args) {
        Solution.main(args);

	}

}
