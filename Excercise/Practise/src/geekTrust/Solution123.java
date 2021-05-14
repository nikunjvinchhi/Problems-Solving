package com.gtnexus.tms.rating.businesslogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution123 {
   public static void main(String[] arg) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      String test = reader.readLine();
      int testCase = Integer.parseInt(test);
      int testNumber = 0;
      while (testCase > 0) {
         testNumber += 1;
         String input = reader.readLine();
         String[] inputs = input.split(" ");
         int n = Integer.parseInt(inputs[0]);
         int b = Integer.parseInt(inputs[1]);
         String price = reader.readLine();
         String[] prices = price.split(" ");
         int a[] = new int[n];
         for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(prices[i]);
         }
         Arrays.sort(a);
         int count = 0;
         for (int i = 0; i < n; i++) {
            if (a[i] < b) {
               count++;
               b -= a[i];
            }
         }
         System.out.println("Case #" + testNumber + ": " + count);
      }
   }
}