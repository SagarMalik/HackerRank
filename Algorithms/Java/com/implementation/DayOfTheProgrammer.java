// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DayOfTheProgrammer {
static class Solution {

    static String solve(int year){
       String dateTemplate="%02d.%02d.%d";
		int day=13,month=9;
		GregorianCalendar calendar= new GregorianCalendar();
		if(year<1918) {
			day=13;
			day=year%4==0?12:13;
			
			return String.format(dateTemplate,day,month,year);
		}
		else if(year>1918) 
		{
			 calendar = new GregorianCalendar();
			 calendar.set(Calendar.YEAR, year     );
				calendar.set(Calendar.DAY_OF_YEAR,256);
		        return String.format(dateTemplate,calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH)+1,year);
			
			
		}
		return String.format(dateTemplate,26,9,1918);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
        in.close();
    }
}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
