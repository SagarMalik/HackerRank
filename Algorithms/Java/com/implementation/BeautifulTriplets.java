// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BeautifulTriplets {
	
	static class Solution {

		static int beautifulTriplets(int d, int[] arr) {
			Map<Integer,Integer> premap=new HashMap<>();
			Map<Integer,Integer> postmap=new HashMap<>();
			int count=0;
			for(int i=0;i<arr.length;i++){
				for(int j=i+1;j<arr.length;j++){
					if (arr[j]-arr[i]==d)
					{
						count=premap.getOrDefault(i,0)+1;
						premap.put(i,count);
						count=postmap.getOrDefault(j,0)+1;
						postmap.put(j,count);
					}
				}
			}
			count=0;
			for(Map.Entry<Integer,Integer> en:premap.entrySet()){
				count+=en.getValue()*postmap.getOrDefault(en.getKey(),0);
			}
			return count;
		}

		private static final Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) throws IOException {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

			String[] nd = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nd[0]);

			int d = Integer.parseInt(nd[1]);

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			int result = beautifulTriplets(d, arr);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();

			bufferedWriter.close();

			scanner.close();
		}
}

	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
