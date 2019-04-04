// Author: Sagar Malik
// https://github.com/SagarMalik

package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EmaSuperComputer {

	static class Solution {

		static class Plus{
			boolean overlap(int i1,int i2,int j1,int j2) {
				return (i1<=j1 && j1<=i2) ||  (i1<=j2 && j2<=i2);  
			}
			int x,y,size,l;
			Set<String> points;
			public Plus(int x,int y,int len) {
				this.x=x;
				this.y=y;
				l=len;
				size=4*l+1;
			}

			public boolean overlap(Plus o){
				Set<String> s1=new HashSet<>(getPoints());
				return s1.removeAll(o.getPoints());
			}
			public Set<String> getPoints(){
				if(points==null) {
					points=new HashSet<>();
					for(int i=-l;i<=l;i++) {
						points.add((x+i)+"_"+y);
						points.add(x+"_"+(y+i));
					}
				}
				return points;
			}

			public int size() {
				return size;
			}
		}

		static boolean canBuild(char [][]grid,int x,int y,int l,int n,int m) {
			return x-l>=0 && grid[x-l][y]=='G'
					&&  x+l<n && grid[x+l][y]=='G'
					&&        y-l>=0 && grid[x][y-l]=='G'
					&&  y+l<m && grid[x][y+l]=='G'    ;


		}

		static int twoPluses(char[][] grid) {
			int n=grid.length,m=grid[0].length;
			List<Plus> list=new ArrayList<>();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(grid[i][j]=='G') {
						int l=0;
						while(canBuild(grid,i,j,l,n,m)) {
							Plus p=new Plus(i,j,l);
							l++;
							list.add(p);
						}
					}
				}
			}
			int max=0;
			int l=list.size();
			for(int i=0;i<l;i++) {
				for(int j=i+1;j<l;j++) {
					if(!list.get(i).overlap(list.get(j))) {
						max=Math.max(max, list.get(i).size()*list.get(j).size());
					}

				}}

			System.out.println(max);
			return max;
		}
		private static final Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) throws IOException {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

			String[] nm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nm[0]);

			int m = Integer.parseInt(nm[1]);

			char[][] grid = new char[n][m];

			for (int i = 0; i < n; i++) {
				String gridItem = scanner.nextLine();
				grid[i] = gridItem.toCharArray();
			}

			int result = twoPluses(grid);

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
