// Author: Sagar Malik
// https://github.com/SagarMalik

package com.graphtheory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SnakesAndLadders {

	static class Solution {
	    static Map<Integer,Integer> mapTransitions;
	    static int []steps;
	 
	    static int quickestWayUp(int[][] ladders, int[][] snakes) {
	    	mapTransitions=new HashMap<>();
	    	steps=new int[101];  // just to align index with square number

	    	Arrays.fill(steps,-1);
	    	for(int []ladder:ladders)         mapTransitions.put(ladder[0],ladder[1]); 
	    	for(int []snake:snakes)         	 mapTransitions.put(snake[0], snake[1]);

	    	//dfs(1,0);
	    	bfs();
	    	return  steps[100];
	    }
	    static void bfs() {
	    	int source=1,dest=1,dist=0;
	    	steps[source]=dist;
	    	Iterator<Integer> nextSquaresIter;
	    	boolean found=false;
	    	Queue<Integer> queue=new ArrayDeque<>();
	    	queue.add(source);
	    	while(!queue.isEmpty() && !found) {  // early exit if reached the end point
	    		source=queue.poll();
	    		dist=steps[source];
	    		if(!mapTransitions.containsKey(source))     // Free rides/ Falls only 
	    		{
	    			nextSquaresIter=IntStream.range(source+1,Math.min(source+7, 101)).iterator();
	    			dist++;
	    		}
	    		else
	    			nextSquaresIter=IntStream.of(mapTransitions.get(source)).iterator();

	    		while(nextSquaresIter.hasNext()) {
	    			dest=nextSquaresIter.next();
	    			found=dest==100;
	    			if(steps[dest]==-1) {
	    				steps[dest]=dist;
	    				queue.add(dest);
	    			}
	    		}	
	    	}
	    }
	    
	    static void dfs(int source,int dist) {
	    	steps[source]=dist;
	    	int dest;

	    	if(mapTransitions.containsKey(source)) {    // Free rides/ Falls only 
	    		dest=mapTransitions.get(source);
	    		if(steps[dest]>dist||steps[dest]==-1)
	    			dfs(dest,dist);
	    	}
	    	else {
	    		dist++;
	    		for( dest=source+1;dest<source+7 && dest<101;dest++) {
	    			if(steps[dest]>dist||steps[dest]==-1)
	    				dfs(dest,dist);
	    		}
	    	}
	    }
	  
	   
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            int n = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int[][] ladders = new int[n][2];

	            for (int i = 0; i < n; i++) {
	                String[] laddersRowItems = scanner.nextLine().split(" ");
	                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	                for (int j = 0; j < 2; j++) {
	                    int laddersItem = Integer.parseInt(laddersRowItems[j]);
	                    ladders[i][j] = laddersItem;
	                }
	            }

	            int m = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int[][] snakes = new int[m][2];

	            for (int i = 0; i < m; i++) {
	                String[] snakesRowItems = scanner.nextLine().split(" ");
	                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	                for (int j = 0; j < 2; j++) {
	                    int snakesItem = Integer.parseInt(snakesRowItems[j]);
	                    snakes[i][j] = snakesItem;
	                }
	            }

	            int result = quickestWayUp(ladders, snakes);

	            bufferedWriter.write(String.valueOf(result));
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
