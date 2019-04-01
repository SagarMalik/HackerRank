// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DesignPDFViewer {

	static class Solution {

	static int designerPdfViewer(int[] h, String word) {
			int n=word.length();
			int height=0;
			for(int i=0;i<n;i++){
				height=Math.max(height,h[word.charAt(i)-'a']);
			}
			return n*height;
		}

		private static final Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) throws IOException {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

			int[] h = new int[26];

			String[] hItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < 26; i++) {
				int hItem = Integer.parseInt(hItems[i]);
				h[i] = hItem;
			}

			String word = scanner.nextLine();

			int result = designerPdfViewer(h, word);

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
