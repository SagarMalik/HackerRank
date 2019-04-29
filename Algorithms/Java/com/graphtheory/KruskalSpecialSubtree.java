// Author: Sagar Malik
// https://github.com/SagarMalik

package com.graphtheory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KruskalSpecialSubtree {

	static class Solution {
		static Map<Integer,Integer> componentMap=new HashMap<>();

		static int find(int src){
			int comp=src;

			if(componentMap.containsKey(src)){
				List<Integer> list=new ArrayList<>();
				while(comp!=componentMap.get(comp)){
					list.add(comp);
					comp=componentMap.get(comp);
				}
				for(Integer i:list)   // Path Compression
					componentMap.put(i,comp);
			}
			componentMap.put(src,comp);
			return comp;
		}
	    static void union(int src,int dest){
	       int small=Math.min(src,dest);
	       int large=Math.max(src,dest);
	       // Avoiding keeping rank find has path compression anyway
	       componentMap.put(find(large),find(small));
	      }
	    // Complete the kruskals function below.
	   //https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
	    static int kruskals(int n, int[][] edges) {
	      Arrays.sort(edges,(a,b)->a[2]-b[2]);
	      int totalWeight=0,counter=0;
	      for(int []edge:edges){
	        if(find(edge[0]) !=find(edge[1])){
	          totalWeight+=edge[2];
	          union(edge[0],edge[1]);
	          counter++;
	          if(counter==n-1) 
	          break;
	        }
	       
	      }
	      return totalWeight;

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String[] nm = scanner.nextLine().split(" ");

	        int n = Integer.parseInt(nm[0]);

	        int m = Integer.parseInt(nm[1]);

	        int[][] edges = new int[m][3];
	       
	        for (int i = 0; i < m; i++) {
	            String[] edgesRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	            for (int j = 0; j < 3; j++) {
	                edges[i][j] = Integer.parseInt(edgesRowItems[j]);
	                }
	                
	        }

	        int result = kruskals(n, edges);

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
