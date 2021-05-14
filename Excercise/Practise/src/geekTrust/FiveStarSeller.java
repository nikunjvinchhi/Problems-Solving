package com.gtnexus.tms.rating.businesslogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FiveStarSeller {

   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int number = Integer.parseInt(reader.readLine());
      List<List<Integer>> productRatings = new ArrayList<List<Integer>>();
      for (int i = 0; i < number; i++) {
         List<Integer> x = new ArrayList<Integer>();
         x.add(Integer.parseInt(reader.readLine()));
         x.add(Integer.parseInt(reader.readLine()));
         productRatings.add(x);
      }
      int ratingsThreshold = Integer.parseInt(reader.readLine());
      System.out.println(fiveStarReviews(productRatings, ratingsThreshold));
   }

   public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold) {

      int totalProduct = productRatings.size();
      PriorityQueue<Products> heap = new PriorityQueue<>(totalProduct, new StarComparator());
      double[] percentageOfProduct = new double[totalProduct];
      double thresold = 0.0;
      double tempThresold = 0.0;
      int count = 0;
      for (List<Integer> temp : productRatings) {
         int fStar = temp.get(0);
         int tReview = temp.get(1);
         double percentage = Math.round(fStar * 100.0 / tReview);
         percentageOfProduct[productRatings.indexOf(temp)] = percentage;
         heap.add(new Products(productRatings.indexOf(temp), fStar, tReview));
         thresold += percentage;
      }
      thresold = Math.round(thresold / 3);
      while (thresold < ratingsThreshold) {
         Products temp = heap.poll();
         //System.out.println(temp);
         temp.fiveStarReview += 1;
         temp.totalReview += 1;
         tempThresold = thresold;
         tempThresold = tempThresold * totalProduct;
         tempThresold -= percentageOfProduct[temp.index];
         percentageOfProduct[temp.index] = Math.round(temp.fiveStarReview * 100.0 / temp.totalReview);
         tempThresold += percentageOfProduct[temp.index];
         tempThresold /= totalProduct;
         thresold = tempThresold;
         //System.out.println(thresold);
         heap.add(temp);
         count++;
      }
      return count;
   }
}


class Products {
   int index;
   int fiveStarReview;
   int totalReview;

   public Products(int pos, int fiveStar, int total) {
      this.index = pos;
      this.fiveStarReview = fiveStar;
      this.totalReview = total;
   }

   @Override public String toString(){
      return this.index + " " + this.fiveStarReview + " " + this.totalReview;
   }
}

/**
 * Max heap comparator based on difference of percentage of original and original + 1
 * @author nvinchhi
 *
 */
class StarComparator implements Comparator<Products> {

   @Override public int compare(Products a, Products b) {

      double bPerce = getPercentageDifference(b);
      double aPerce = getPercentageDifference(a);
      //double diff = bPerce - aPerce;
      if (aPerce < bPerce) {
         return 1;
      } else if (aPerce > bPerce){
         return -1;
      } else
         return 0;
   }

   private int getPercentageDifference(Products o1) {
      double percentage = Math.round(o1.fiveStarReview * 100 / o1.totalReview);
      double Add1percentage = Math.round((o1.fiveStarReview + 1) * 100 / (o1.totalReview +1) );
      return (int) (Add1percentage - percentage);
   }

}
