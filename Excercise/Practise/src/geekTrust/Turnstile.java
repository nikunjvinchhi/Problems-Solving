package com.gtnexus.tms.rating.businesslogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Sample input way
 *numCustomers = 5
arrTime = [0,1,1,3,3]
direction = [0, 1, 0, 0, 1]
Output: [0, 2, 1, 4, 3]

5
0
0
1
1
1
0
3
0
3
1
 * @author nvinchhi
 *
 */
public class Turnstile {

   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int number = Integer.parseInt(reader.readLine());

      int[] arrivalTime = new int[number];
      int[] departureSign = new int[number];
      for (int i = 0; i < number; i++) {
         arrivalTime[i] = Integer.parseInt(reader.readLine());//arrival time
         departureSign[i] = Integer.parseInt(reader.readLine());//departure time
      }
      List<Integer> result = turnstile(number, arrivalTime, departureSign);
   }

   private static List<Integer> turnstile(int customers, int[] arrivalTime, int[] departureSign) {
      boolean decider = true;
      CompareCustomer compare = new CompareCustomer(decider);
      PriorityQueue<Customers> heap = new PriorityQueue<>(customers, compare);
      for (int i = 0; i < customers; i++) {
         heap.add(new Customers(i, arrivalTime[i], departureSign[i]));
      }
      int[] temp = new int[customers];
      while (heap.size() != 0) {
         Customers x = heap.poll();
         Iterator<Customers> te = heap.iterator();
         compare.mutex = x.deparSign == 1 ? true : false;
         List<Customers> toBeUpdated = new ArrayList<Customers>();
         while (te.hasNext()) {
            Customers y = te.next();
            if (y.arrivalTime == x.arrivalTime) {
               y.arrivalTime += 1;
            }
            te.remove();
            toBeUpdated.add(y);
         }
         if (toBeUpdated.size() > 0)
            heap.addAll(toBeUpdated);
         temp[x.index] = x.arrivalTime;
      }
      StringBuilder answer = new StringBuilder();
      answer.append("[");
      for (int i = 0; i < customers; i++) {
         answer.append(temp[i]).append(",");
      }
      System.out.println(answer.toString());
      return null;
   }
}


class Customers {
   int index;
   int arrivalTime;
   int deparSign;

   public Customers(int index, int arrivalTime, int deparTime) {
      this.index = index;
      this.arrivalTime = arrivalTime;
      this.deparSign = deparTime;
   }
}


class CompareCustomer implements Comparator<Customers> {

   public boolean mutex;

   public CompareCustomer(boolean mutex) {
      this.mutex = mutex;
   }

   @Override public int compare(Customers a, Customers b) {

      if (a.arrivalTime == b.arrivalTime) {
         if (a.deparSign > b.deparSign) {
            return this.mutex ? -1 : 1;
         } else if (a.deparSign < b.deparSign) {
            return this.mutex ? 1 : -1;
         } else {
            return 0;
         }
      } else if (a.arrivalTime > b.arrivalTime) {
         return 1;
      } else if (a.arrivalTime < b.arrivalTime) {
         return -1;
      }
      return 0;
   }
}