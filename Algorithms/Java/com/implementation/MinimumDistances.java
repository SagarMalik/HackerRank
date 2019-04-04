// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MinimumDistances {

	static class Solution {

	    static int minimumDistances(int[] a) {
	        Set<Integer> set=new HashSet<>();
	        int max=a.length;
	        for(int i=0;i<a.length;i++){
	            if(set.contains(a[i]))
	                continue;
	            set.add(a[i]);
	            for(int j=i+1;j<a.length && j<i+max;j++){
	                if(a[j]==a[i]){
	                    if(j==i+1) return 1;
	                    max=max<j-i?max:j-i;
	                    break;
	                }
	            
	            }
	        }
	        return max==a.length?-1:max;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i = 0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        int result = minimumDistances(a);
	        System.out.println(result);
	        in.close();
	    }
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
