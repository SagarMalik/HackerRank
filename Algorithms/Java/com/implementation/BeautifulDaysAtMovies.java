// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BeautifulDaysAtMovies {

	static  class Solution {

	    // Complete the beautifulDays function below.
	    static int rev(int num){
	      int result=0;
	      while(num>0){
	        result=result*10+num%10;
	        num/=10;
	      }
	      return result;
	    }
	    static int beautifulDays(int i, int j, int k) {
	     int result=0;
	      while(i<=j){
	        if(Math.abs(i-rev(i++))%k==0)
	        result++;
	      }
	   return result;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String[] ijk = scanner.nextLine().split(" ");

	        int i = Integer.parseInt(ijk[0]);

	        int j = Integer.parseInt(ijk[1]);

	        int k = Integer.parseInt(ijk[2]);

	        int result = beautifulDays(i, j, k);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}

	
	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
