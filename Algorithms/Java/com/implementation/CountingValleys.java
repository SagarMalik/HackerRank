// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.util.Scanner;

public class CountingValleys {
static class Solution {

    static int countingValleys(int n, String s) {
        int cumul=0,prev=0;
        char []steps=s.toCharArray();
        int curr=0;
        int valleyCount=0;
        for(char c:steps){
            curr=c=='U'?1:-1;
            cumul+=curr;
            if(prev==0 && cumul==-1)
                valleyCount++;
            prev=cumul;
        }
        return valleyCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }
}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
