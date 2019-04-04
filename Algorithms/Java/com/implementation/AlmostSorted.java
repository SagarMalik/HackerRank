package com.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class AlmostSorted {

	static class Solution {

		// Complete the almostSorted function below.
		static void almostSorted(int[] arr) {
			int n=arr.length;
			int []arr2=Arrays.copyOf(arr, arr.length);
			Arrays.sort(arr2);
			int diff=0;
			for(int i=0;i<n;i++) diff+=arr2[i]!=arr[i]?1:0;
			if(diff==0)
			{
				System.out.println("yes");
				return;
			}
			if(diff==2)
			{
				System.out.println("yes");
				System.out.print("swap");
				for(int i=0;i<n;i++) { 
					if(arr2[i]!=arr[i])
						System.out.print(" "+(i+1));
				}
				System.out.println("");
				return;
			}
			int start=-1,end=-1;
			for(int i=0;i<n;i++) { 
				if(arr2[i]!=arr[i])
				{
					if(start==-1)
						start=i;
					else
						end=i;
				}        

			}
			boolean possible=end!=-1;
			for(int i2=start,j2=end;i2<=j2;i2++,j2--) {
				if(arr[i2]!=arr2[j2])
				{
					possible=false;
					break;
				}

			}
			if(possible) {
				System.out.println("yes");
				System.out.println("reverse "+(start+1)+" "+(end+1));
				return ;
			}
			System.out.println("no");
		}
		static boolean sameDirection(int i,int j, boolean neg) {
			return neg && i>j || !neg && i<j;
		}
		private static final Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			almostSorted(arr);

			scanner.close();
		}
	}

	public static void main(String[] args) {
		Solution.main(args);

	}

}
