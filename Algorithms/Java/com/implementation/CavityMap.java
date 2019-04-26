// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CavityMap {
static  class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
     
     StringBuilder sb=new StringBuilder();
     int n=grid.length;
     int l=grid[0].length();
     String [] result=new String[n];
     result[0]=grid[0];
     String st;
     for(int i=1;i<grid.length-1;i++){
     sb.setLength(0);
     st=grid[i];
     sb.append(st.charAt(0));
     for(int j=1;j<l-1;j++)
     {
       char c=st.charAt(j);
       if(c>grid[i-1].charAt(j) && c>grid[i+1].charAt(j) && c>st.charAt(j-1) && c>st.charAt(j+1))
       c='X';
      sb.append(c);
     }

     if(l>1)
     sb.append(st.charAt(l-1));
     result[i]=sb.toString();
     }
     if(n>1) result[n-1]=grid[n-1];
    return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

	public static void main(String[] args) throws IOException {
		Solution.main(args);

	}

}
