// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.util.Scanner;

public class FormingAMagicSquare {
	static class Solution {
		private static int [][][]squares={{ {8,1,6},{3,5,7},{4,9,2} }
		,{ {4,9,2},{3,5,7},{8,1,6} }
		,{ {2,9,4},{7,5,3},{6,1,8} }
		,{ {6,1,8},{7,5,3},{2,9,4} }
		,{{8,3,4},{1,5,9},{6,7,2} }
		,{ {4,3,8},{9,5,1},{2,7,6} }
		,{{2,7,6},{9,5,1},{4,3,8}}
		,{{6,7,2},{1,5,9},{8,3,4}} 
		};

		static int formingMagicSquare(int[][] s) {
			int min=cost(squares[0],s);
			int c=0;
			for(int i=1;i<8;i++){
				c=cost(squares[i],s);
				min=min<c?min:c;

			}
			return min;
		}
		public static int cost(int [][]a,int [][]b)
		{
			int sum=0;
			int singlecost=0;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++)
				{
					singlecost=a[i][j]-b[i][j];
					sum+=singlecost<0?-singlecost:singlecost;
				}
			}
			return sum;
		}

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int[][] s = new int[3][3];
			for(int s_i = 0; s_i < 3; s_i++){
				for(int s_j = 0; s_j < 3; s_j++){
					s[s_i][s_j] = in.nextInt();
				}
			}
			int result = formingMagicSquare(s);
			System.out.println(result);
			in.close();
		}
}


	public static void main(String[] args) {
		Solution.main(args);

	}

}
