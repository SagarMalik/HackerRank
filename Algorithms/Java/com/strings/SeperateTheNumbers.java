// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.util.Scanner;

public class SeperateTheNumbers {

	static class Solution {

		  static void separateNumbers(String s) {
		      
		    boolean found = false;
		    long num=0;
		    if(s.startsWith("0"))
		    {
		         System.out.println("NO");
		         return;
		    }
		    int len=0;
		    while(true){
		        len++;
		        boolean additional=false;
		        if(len > (s.length()+1)/2) {
		            break;
		        }
		        long posFirst=Long.valueOf(s.substring(0,len));
		       
		        num=posFirst;
		        String st=s.substring(len);
		       
		        
		        while(st.length()!=0 && st.startsWith(String.valueOf(++posFirst))) {
		            st=st.substring(String.valueOf(posFirst).length());
		            additional=true;
		        }
		        if (st.length()==0 && additional) {
		            

		            found=true;
		            break;
		        }
		      

		    }
		    if (!found){
		        System.out.println("NO");
		     return;
		    }
		    
		    System.out.println("YES "+num);
		    }
		    

		    private static final Scanner scanner = new Scanner(System.in);

		    public static void main(String[] args) {
		        int q = scanner.nextInt();
		        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		        for (int qItr = 0; qItr < q; qItr++) {
		            String s = scanner.nextLine();

		            separateNumbers(s);
		        }

		        scanner.close();
		    }
		}
	public static void main(String[] args) {
	Solution.main(args);

	}

}
