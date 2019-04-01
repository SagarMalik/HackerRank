// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class CatsAndaMouse {

	static class Solution {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int x = in.nextInt();
	            int y = in.nextInt();
	            int z = in.nextInt();
	            int dis1=x-z;
	            int dis2=y-z;
	            dis1=dis1>0?dis1:-dis1;
	            dis2=dis2>0?dis2:-dis2;
	            System.out.println(dis1<dis2?"Cat A":dis2<dis1?"Cat B":"Mouse C");
	            in.close();
	        }
	    }
	}
 
	
	public static void main(String[] args) {
		Solution.main(args);

	}

}
