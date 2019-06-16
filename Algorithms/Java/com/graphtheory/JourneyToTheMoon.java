// Author: Sagar Malik
// https://github.com/SagarMalik


package com.graphtheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JourneyToTheMoon {

  static class Solution {
    public static void main(String[] args) throws Exception {
      BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
      String[] temp = bfr.readLine().split(" ");
      int N = Integer.parseInt(temp[0]);
      int I = Integer.parseInt(temp[1]);
      Astronauts astronauts = new Astronauts(N);

      for (int i = 0; i < I; i++) {
        temp = bfr.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        // Store a and b in an appropriate data structure of your choice
        astronauts.add(a, b);
      }


      long combinations = astronauts.combocount();

      // Compute the final answer - the number of combinations

      System.out.println(combinations);

    }

    static class Astronauts {
      private int[] countries;

      public Astronauts(int n) {
        countries = new int[n];
        for (int i = 0; i < n; i++)
          countries[i] = i;
      }

      public boolean samecountry(int i, int j) {
        return findcountry(i) == findcountry(j);
      }

      public int findcountry(int i) {
        while (i != countries[i])
          i = countries[i];
        return i;
      }

      public void combine(int p, int q) {
        int i = findcountry(p);
        int j = findcountry(q);
        if (i == j)
          return;
        countries[i] = j;
      }

      public void add(int i, int j) {
        if (!samecountry(i, j))
          combine(i, j);

      }

      public long combocount() {
        Map<Integer, Integer> countrycount = new HashMap<>();
        int country, count = 0;
        for (int i : countries) {
          country = findcountry(i);
          count = 1;
          if (countrycount.containsKey(country))
            count += countrycount.get(country);
          countrycount.put(country, count);

        }
        long product = 0;
        for (int j : countrycount.values())
          product += (j * (countries.length - j));
        return product / 2;
      }
    }


  }

  public static void main(String[] args) throws Exception {
    Solution.main(args);

  }

}
