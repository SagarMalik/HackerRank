// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class SockMerchant {
static class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[100];
        int sum=0;
       // in.nextLine();
        for(int c_i=0; c_i < n; c_i++){
            c[in.nextInt()-1]++ ;
        }
      for(int c_i=0; c_i < 100; c_i++){
            sum+=c[c_i]/2 ;
        }
        System.out.println(sum);
        in.close();
    }
}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
