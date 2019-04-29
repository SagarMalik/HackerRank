// Author: Sagar Malik
// https://github.com/SagarMalik

package com.graphtheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;



public class DijkstraShortestReach2 {
	static class  Solution {
		//Remap the index for result distance array
	      static int m(int i,int s){
	          return i<s?i-1:i-2;
	        }
	      static int[] shortestReach(int n, int m, Map<Integer,Map<Integer,Integer>> edgeMap, int s) {
	    	
	    	  int []distances=new int[n-1];
	    	  Arrays.fill(distances,-1);
	    	  Queue<Integer> q=new ArrayDeque<>();
	      	  q.add(s);
	    	  int dist=0,idx;
	    	  while(!q.isEmpty()){
	    		  
	    		  int qsize=q.size();
	    		  while(qsize-->0){
	    			  int src=q.poll(); 
	    			  dist=src==s?0:distances[m(src,s)];
	    			  Map<Integer,Integer> neighbors=edgeMap.get(src);
	    			  if(neighbors!=null){
	    				  for(Map.Entry<Integer,Integer> neighbor:neighbors.entrySet()){
	    					  int node=neighbor.getKey();
	    					  int weight=neighbor.getValue();
	    					  idx=m(node,s);
	    					  if(node!=s && (distances[idx]==-1||distances[idx]>dist+weight)){
	    						  q.add(node);
	    						  distances[idx]=dist+weight;
	    					  }

	    				  }

	    			  }
	    		  }
	    	  }
	    	  return distances;
	      }
	      static void ensureEdge(Map<Integer,Map<Integer,Integer>> edgeMap,int src,int dest,int weight){
	         Map<Integer,Integer> map;
	          map=edgeMap.get(src);
	         if(map==null){
	           map=new HashMap<>();
	           edgeMap.put(src,map);
	          } 
	          if(!map.containsKey(dest)||map.get(dest)>weight)  // Replace the costlier Edge if present
	        	  map.put(dest,weight);
	      }
	      // Scanner causes timeout for last case so use buffered Reader
	      private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	      public static void main(String[] args) throws IOException {
	          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	          int q = Integer.valueOf(bufferedReader.readLine().trim());
	        

	          for (int qItr = 0; qItr < q; qItr++) {
	              String[] nm = bufferedReader.readLine().split(" ");

	              int n = Integer.parseInt(nm[0]);

	              int m = Integer.parseInt(nm[1]);

	              
	              Map<Integer,Map<Integer,Integer>> edgeMap=new HashMap<>();
	             
	              for (int i = 0; i < m; i++) {
	                  String[] edgesRowItems = bufferedReader.readLine().split(" ");
	                

	                      
	                      int src = Integer.parseInt(edgesRowItems[0]);
	                      int dest = Integer.parseInt(edgesRowItems[1]);
	                      int weight= Integer.parseInt(edgesRowItems[2]);
	                     ensureEdge(edgeMap,src,dest,weight);
	                     ensureEdge(edgeMap,dest,src,weight);
	                  
	              }

	              int s =  Integer.valueOf(bufferedReader.readLine().trim());
	              int[] result = shortestReach(n, m, edgeMap, s);

	              for (int i = 0; i < result.length; i++) {
	                  bufferedWriter.write(String.valueOf(result[i]));

	                  if (i != result.length - 1) {
	                      bufferedWriter.write(" ");
	                  }
	              }

	              bufferedWriter.newLine();
	          }

	          bufferedWriter.close();

	          bufferedReader.close();
	      }
	}
	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
