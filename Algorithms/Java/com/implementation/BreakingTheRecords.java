// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class BreakingTheRecords {
static class Solution {

    static int[] getRecord(int[] s){
        int maxcount=0,mincount=0,min=s[0],max=s[0];
        for(int i=1;i<s.length;i++){
            if(s[i]<min)
            {
                mincount++;
                min=s[i];
            }
            else if(s[i]>max)
            {
                maxcount++;
                max=s[i];
            }
            
        }
        return new int[]{maxcount,mincount};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
        in.close();
    }
}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
