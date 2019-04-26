package com.strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TwoCharacters {
  static class Solution {

	    // Complete the alternate function below.
	  static int alternate(String s) {
		  Set<Character> charSet=new HashSet<>();
		  char []chars=s.toCharArray();
		  for(char c:chars)  charSet.add(c);
		  int maxLen=0,len=0;
		  char prev=0;
		  for(char c:charSet) {
			  for(char d:charSet) {
				  if(c<d) {   // Avoid the duplicate iteration (a,b) and (b,a)
					  len=prev=0;
					  for(int i=0;i<chars.length;i++) {
						  if(chars[i]==c||chars[i]==d) {
							  if(prev==chars[i]) // Kill the need of additional function and fail fast in case of consecutive same characters
							  {	
								  len=0;  // Just to show the string is invalid
								  break; 
							  }
							  prev=chars[i];
							  len++;
						  }
					  }
					  maxLen=Math.max(maxLen, len);
				  }
			  }
		  }
		  return maxLen;
	  }

	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int l = Integer.parseInt(bufferedReader.readLine().trim());

	        String s = bufferedReader.readLine();

	        int result = alternate(s);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}

  public static void main(String[] args) throws IOException {
		Solution.main(args);

	}


}
