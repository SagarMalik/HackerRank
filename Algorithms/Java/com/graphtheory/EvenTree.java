// Author: Sagar Malik
// https://github.com/SagarMalik

package com.graphtheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class EvenTree {

	static class Solution {
		static class TreeNode{
			  private static Map<Integer,TreeNode> keeper=new HashMap<>();
			  int val;
			  List<TreeNode> children;
			public TreeNode(int v){
			  val=v;
			  children=new ArrayList<>();
			  keeper.put(val,this);
			}
			public void addChild(TreeNode t){
			 children.add(t);
			}

			public static void AddConnection(int child,int parent){
			TreeNode p=keeper.get(parent);
			if(p==null)p=new TreeNode(parent);
			TreeNode c=keeper.get(child);
			if(c==null)c=new TreeNode(child);
			p.addChild(c);
			}
			public static TreeNode getRoot(){
			  return keeper.get(1);
			}
			static int count=0;
			public int getCount(){
			int ct=1;
			for(TreeNode c:children){
			  int childCount=c.getCount();

			  if(childCount%2!=0)
			    ct+=childCount;
			  else
			    count++;
			  
			}
			return ct;
			}
			public static int populate(){
			  TreeNode root=getRoot();
			   root.getCount();
			   return count;
			}

			}
			    // Complete the evenForest function below.
			    

			    public static void main(String[] args) throws IOException {
			        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

			        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			        int tNodes = Integer.parseInt(tNodesEdges[0]);
			        int tEdges = Integer.parseInt(tNodesEdges[1]);

			        List<Integer> tFrom = new ArrayList<>();
			        List<Integer> tTo = new ArrayList<>();

			        IntStream.range(0, tEdges).forEach(i -> {
			            try {
			                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
             	            TreeNode.AddConnection(Integer.parseInt(tFromTo[0]),Integer.parseInt(tFromTo[1]));
			            } catch (IOException ex) {
			                throw new RuntimeException(ex);
			            }
			        });

			        int res = TreeNode.populate();

			        bufferedWriter.write(String.valueOf(res));
			        bufferedWriter.newLine();

			        bufferedReader.close();
			        bufferedWriter.close();
			    }
			}

	public static void main(String[] args) {
		

	}

}
