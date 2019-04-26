// Author: Sagar Malik
// https://github.com/SagarMalik

package com.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformString {

	static class Solution {
		public static Set<Integer> getResultSet(String st){
		    int l=st.length();
		    int i=0,j=0;
		    Set<Integer> set=new HashSet<>();
		    char c;
		    for(i=0;i<l;){
		        c=st.charAt(i);
		        for(j=1;i+j<l;j++){
		            if(c!=st.charAt(i+j))
		            break;
		            set.add((c-96)*j);
		        }
		        i+=j;
		        set.add((c-96)*j);
		    }
		    return set;
		}
		    
		    public static void main(String[] args) {
		        Scanner in = new Scanner(System.in);
		        String s = in.next();
		        int n = in.nextInt();
		        Set<Integer> set= getResultSet(s);
		        for(int a0 = 0; a0 < n; a0++){
		            int x = in.nextInt();
		           if(set.contains(x))
		               System.out.println("Yes");
		            else
		                System.out.println("No");
		        }
		        in.close();
		    }
		}
	public static void main(String[] args) {
		Solution.main(args);

	}

}
