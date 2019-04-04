// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FairRatios {

	static  class Solution {

	  static int fairRations(int[] B) {
	    int sum=0,chain=0;
	    boolean fChain=false;
	    for(int i=0;i<B.length;i++)
	    {
	        sum+=B[i];

	        if(B[i]%2==1){
	            fChain=!fChain;
	             }
	       
	            if (fChain)
	            chain++;
	       
	    }
	    if(sum%2==1)
	    return -1;
	    return chain*2;

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int N = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] B = new int[N];

	        String[] BItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < N; i++) {
	            int BItem = Integer.parseInt(BItems[i]);
	            B[i] = BItem;
	        }

	        int result = fairRations(B);

	        bufferedWriter.write(result!=-1?String.valueOf(result):"NO");
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}

	public static void main(String[] args) throws IOException {
	Solution.main(args);	
	}

}
