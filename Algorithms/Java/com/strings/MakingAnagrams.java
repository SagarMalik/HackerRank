// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {

	static class Solution {

	    // Complete the makingAnagrams function below.
	    static int makingAnagrams(String s1, String s2) {
	       int n1=s1.length(),n2=s2.length();
	       
	        
	        int []chars=new int[26];
	        for(int i=0;i<n1;i++) chars[s1.charAt(i)-'a']++; 
	        for(int i=0;i<n2;i++) chars[s2.charAt(i)-'a']--; 
	        int changes=0;
	        for(int i=0;i<chars.length;i++) changes+=Math.abs(chars[i]); 
	          return changes;


	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String s1 = scanner.nextLine();

	        String s2 = scanner.nextLine();

	        int result = makingAnagrams(s1, s2);

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
