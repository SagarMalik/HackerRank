// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CeaserCipher {

	static class Solution {
	    // Complete the caesarCipher function below.
	    static String caesarCipher(String s, int k) {
	    k=k%26;
	    char []chars=s.toCharArray();
	    int n=chars.length;
	    for(int i=0;i<n;i++){
	      if(chars[i]>='a' && chars[i]<='z'){
	       chars[i]=(char)('a'+(chars[i]-'a'+k)%26);
	      }
	      else if(chars[i]>='A' && chars[i]<='Z')
	      {
	       chars[i]=(char)('A'+(chars[i]-'A'+k)%26);
	      }
	    }
	    return new String(chars);
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        String s = scanner.nextLine();

	        int k = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        String result = caesarCipher(s, k);

	        bufferedWriter.write(result);
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}

	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
