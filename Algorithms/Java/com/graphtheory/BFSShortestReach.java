// Author: Sagar Malik
// https://github.com/SagarMalik

package com.graphtheory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestReach {

	static class  Solution {
		//Remap the index for result distance array
	      static int m(int i,int s){
	          return i<s?i-1:i-2;
	        }
	      // Complete the bfs function below.
	      static int[] bfs(int n, int m, Map<Integer,List<Integer>> edgeMap, int s) {
	    	  boolean []visited=new boolean[n+1]; // to use the the index directly
	    	  int []distances=new int[n-1];
	    	  Arrays.fill(distances,-1);
	    	  Queue<Integer> q=new ArrayDeque<>();
	    	  visited[s]=true;
	    	  q.add(s);
	    	  int dist=0;
	    	  while(!q.isEmpty()){
	    		  dist+=6;
	    		  int qsize=q.size();
	    		  while(qsize-->0){
	    			  int src=q.poll(); 
	    			  List<Integer> neighbors=edgeMap.get(src);
	    			  if(neighbors!=null){
	    				  for(int neighbor:neighbors){
	    					  if(!visited[neighbor]){
	    						  q.add(neighbor);
	    						  visited[neighbor]=true;
	    						  distances[m(neighbor,s)]=dist;
	    					  }

	    				  }

	    			  }
	    		  }
	    	  }
	    	  return distances;
	      }
	      static void ensureEdge(Map<Integer,List<Integer>> edgeMap,int src,int dest){
	         List<Integer> l;
	          l=edgeMap.get(src);
	                      if(l==null){
	                        l=new ArrayList<>();
	                        edgeMap.put(src,l);
	                      }
	                      l.add(dest);
	      }
	      private static final Scanner scanner = new Scanner(System.in);

	      public static void main(String[] args) throws IOException {
	          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	          int q = scanner.nextInt();
	          scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	          for (int qItr = 0; qItr < q; qItr++) {
	              String[] nm = scanner.nextLine().split(" ");

	              int n = Integer.parseInt(nm[0]);

	              int m = Integer.parseInt(nm[1]);

	              
	              Map<Integer,List<Integer>> edgeMap=new HashMap<>();
	             
	              for (int i = 0; i < m; i++) {
	                  String[] edgesRowItems = scanner.nextLine().split(" ");
	                  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	                      
	                      int src = Integer.parseInt(edgesRowItems[0]);
	                      int dest = Integer.parseInt(edgesRowItems[1]);
	                     ensureEdge(edgeMap,src,dest);
	                     ensureEdge(edgeMap,dest,src);
	                  
	              }

	              int s = scanner.nextInt();
	              scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	              int[] result = bfs(n, m, edgeMap, s);

	              for (int i = 0; i < result.length; i++) {
	                  bufferedWriter.write(String.valueOf(result[i]));

	                  if (i != result.length - 1) {
	                      bufferedWriter.write(" ");
	                  }
	              }

	              bufferedWriter.newLine();
	          }

	          bufferedWriter.close();

	          scanner.close();
	      }
	  }

	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
