package com.gtnexus.tms.rating.businesslogic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FreshCodePromotion {

   public static void main(String[] args) {
      BufferedReader inoutBuffer = new BufferedReader(new InputStreamReader(System.in));
      String[][] codeList1 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
      String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};

      String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
      String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};

      String[][] codeList3 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
      String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};

      String[][] codeList4 = {{"apple", "apple"}, {"apple", "apple", "banana"}};
      String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};

      String[][] codeList5 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
      String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};

      String[][] codeList6 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
      String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};

      String[][] codeList7 = {{"anything", "apple"}, {"banana", "anything", "banana"}};
      String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};

      String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
      String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};

      String[][] codeList9 = {{"anything", "anything", "anything", "apple"}, {"banana", "anything", "banana"}};
      String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

      System.out.println(isCustomerWinner(codeList1, shoppingCart1) ? 1 : 0);
      System.out.println(isCustomerWinner(codeList2, shoppingCart2) ? 1 : 0);
      System.out.println(isCustomerWinner(codeList3, shoppingCart3) ? 1 : 0);
      System.out.println(isCustomerWinner(codeList4, shoppingCart4) ? 1 : 0);
      System.out.println(isCustomerWinner(codeList5, shoppingCart5) ? 1 : 0);
      System.out.println(isCustomerWinner(codeList6, shoppingCart6) ? 1 : 0);
      System.out.println(isCustomerWinner(codeList7, shoppingCart7) ? 1 : 0);
      System.out.println(isCustomerWinner(codeList8, shoppingCart8) ? 1 : 0);
      System.out.println(isCustomerWinner(codeList9, shoppingCart9) ? 1 : 0);

   }

   /**
    * This is similar to find a subsequence from the given string just keep in mind we have to maintain order of codes.
    * @param codeList
    * @param shoppingCart
    * @return
    */
   private static boolean isCustomerWinner(String[][] codeList, String[] shoppingCart) {
      int k = 0;
      int i = 0;
      for (i = 0; i < codeList.length && k + codeList[i].length <= shoppingCart.length;) {
         int j = 0;
         boolean z = true;
         int noOfAnyThing = 0;
         int matched = 0;
         while (j < codeList[i].length) {
            if (codeList[i][j].equalsIgnoreCase(shoppingCart[k + j])) {
               matched += 1;
            } else if (codeList[i][j].equalsIgnoreCase("Anything")) {
               noOfAnyThing += 1;
            } else {//if you don't find then break the loop.
               z = false;
               k = k + j + 1 - noOfAnyThing - matched; //next shopping cart item to compare with codes.
               break;
            }
            j++;
         }
         if (z) {//you find the code in shopping cart
            k = k + codeList[i].length;//jump K so it will point next fruits from shopping
            i++;//check for next code.
         }
         /*else
          k++;//increment so it will start from next
         */ }
      return i == codeList.length ? true : false;
   }

}
