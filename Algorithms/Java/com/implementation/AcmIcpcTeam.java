// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class AcmIcpcTeam {

	static  class Solution {

	    public static void main(String[] args) {
		        Scanner in = new Scanner(System.in);
		        int n = in.nextInt();
		        int m = in.nextInt();
		        boolean [][]sets=new boolean[n][m];
		        String st;
			       
		        for(int i = 0; i < n; i++){
		            st=in.next();
	             
	             for(int j=0;j<m;j++) {
	              if (st.charAt(j)=='1') sets[i][j]=true;
	             }
		        }
		        int[] result = acmTeam(sets);
		        for (int i = 0; i < result.length; i++) {
		            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		        }
		        System.out.println("");


		        in.close();
		    }
		    private static int[] acmTeam(boolean[][] sets) {
		    	int tMax,max=-1,nteam=0;
			     for(int i=0;i<sets.length;i++)
			     {
			    	 for(int j=i+1;j<sets.length;j++) 
			    	 {
			    		tMax=0;
			    		for(int k=0;k<sets[j].length;k++)
			    		tMax+=sets[i][k]||sets[j][k]?1:0;
			    		if (tMax==max)
			    			nteam++;
			    		else if(tMax>max) {
			    			max=tMax;
			    			nteam=1;
			    		}
			    	 }
			     }
			     return new int[] {max,nteam};
		}
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
