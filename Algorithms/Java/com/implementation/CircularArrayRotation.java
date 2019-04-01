// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.util.Scanner;

public class CircularArrayRotation {
static  class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int l=a.length;
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            System.out.println(a[(m-k%l+l)%l]);
        }
        in.close();
    }
}

	public static void main(String[] args) {
	Solution.main(args);

	}

}
