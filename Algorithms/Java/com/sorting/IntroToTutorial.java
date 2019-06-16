// Author: Sagar Malik
// https://github.com/SagarMalik

package com.sorting;

import java.util.Scanner;

public class IntroToTutorial {

  static class Solution {

    public static void main(String[] args) {
      /*
       * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
       * named Solution.
       */
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
      int low = 0;
      int high = n - 1;
      int mid;
      while (low < high) {
        mid = (low + high) / 2;
        if (num == arr[low]) {
          System.out.println(low);
          break;
        } else if (num == arr[high]) {
          System.out.println(high);
          break;
        }

        else if (num > arr[mid])
          low = mid;
        else
          high = mid;


      }
      sc.close();
    }
  }

  public static void main(String[] args) {
    Solution.main(args);

  }

}
