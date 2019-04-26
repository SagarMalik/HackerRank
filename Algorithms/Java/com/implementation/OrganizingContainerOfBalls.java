// Author: Sagar Malik
// https://github.com/SagarMalik


package com.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainerOfBalls {
static class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
    if(container.length!=container[0].length)
    return "Impossible";
    int []rows=new int[container.length];
    int []cols=new int[container[0].length];
    
    for(int i=0;i<container.length;i++){
      for(int j=0;j<container[0].length;j++){
        rows[i]+=container[i][j];
        cols[j]+=container[i][j];
      }
    }
Arrays.sort(rows);
Arrays.sort(cols);
for(int i=0;i<rows.length;i++)
{
  if(rows[i]!=cols[i])
  return "Impossible";
}
return "Possible";
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
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
