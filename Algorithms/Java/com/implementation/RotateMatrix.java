package com.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RotateMatrix {

	static class Solution {
		static void printMatrix(List<List<Integer>> matrix) {
			boolean first=true;  
			for(List<Integer>row : matrix) {
				first=true;
				for(Integer column: row) {
					if(!first)
						System.out.print(" ");
					first=false;
					System.out.print(column);
				}
				System.out.println( );
			}
		}
		static void rotateLayer(List<List<Integer>> matrix,int row,int column, int rotation,int iStart,int jStart) {
			int factor=2*(row+column)-4,jEnd=jStart+column-1,iEnd=iStart+row-1;
			rotation=rotation%(factor);
			List<Integer>  temp=new ArrayList<>();
			for(int  j=jStart;j<=jEnd;j++)  temp.add(matrix.get(iStart).get(j));
			for(int  j=iStart+1;j<iEnd;j++) temp.add(matrix.get(j).get(jEnd));
			for(int  j=jEnd;j>=jStart;j--)  temp.add(matrix.get(iEnd).get(j));
			for(int  j=iEnd-1;j>iStart;j--)  temp.add(matrix.get(j).get(jStart));
			int pos=rotation;
			for(int j=0;j<column;j++)   matrix.get(iStart).set(jStart+j,temp.get(pos++%factor));
			for(int j=1;j<row-1;j++)    matrix.get(iStart+j).set(jEnd,temp.get(pos++%factor));
			for(int j=1;j<column;j++)   matrix.get(iEnd).set(jEnd-j,temp.get(pos++%factor));
			for(int j=1;j<row-1;j++)    matrix.get(iEnd-j).set(jStart,temp.get(pos++%factor));     

		}
	
		static void matrixRotation(List<List<Integer>> matrix, int r) {
			int m=matrix.size(),n=matrix.get(0).size();
			int layer_count=Math.min(n,m)/2;
			for(int k=0;k<layer_count;k++) {
				rotateLayer(matrix,m-2*k,n-2*k,r,k,k);
			}
			printMatrix(matrix);

		}

		public static void main(String[] args) throws IOException {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			int m = Integer.parseInt(mnr[0]);

			int n = Integer.parseInt(mnr[1]);

			int r = Integer.parseInt(mnr[2]);

			List<List<Integer>> matrix = new ArrayList<>();

			IntStream.range(0, m).forEach(i -> {
				try {
					matrix.add(
							Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
							.map(Integer::parseInt)
							.collect(Collectors.toList())
							);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			});

			matrixRotation(matrix, r);

			bufferedReader.close();
		}
	}

	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
