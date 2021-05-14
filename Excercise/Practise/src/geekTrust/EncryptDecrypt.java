package com.gtnexus.tms.rating.businesslogic;

import java.util.Stack;

/**
 * Problem Statement
 *
Carer cup Persons A and B uses an encryption based system for their conversation.
Each conversation message is encoded from the source and decoded in
the destination using a shared private positive number key known to each other.
The algorithm is illustrated with an example.
Input Format with explanation:

Operation (1 for Encoding and 2 for Decoding)
Input message
Input private key
Example:

input 1 Message: Open Key: 123

Output: Oppeeen

Input: 2 Oppeeen 123

Output: Open
 *
 * @author nvinchhi
 *
 */

public class EncryptDecrypt {

   public static void main(String[] args) {

      char[] a = new char[7];
      a[0] = 'a';
      a[1] = 'b';
      a[2] = 'b';
      a[3] = 'b';
      a[4] = 'b';
      a[5] = 'b';
      a[6] = 'b';
      compress(a);
      System.out.println(trailingZeroes(50));
      System.out.println(channel(1, "open", "123"));

      System.out.println(channel(2, "oppxxxn", "123"));

      System.out.println(channel(1, "abcdefgh", "33333333333"));

      System.out.println(channel(2, "aaabbbcccdddeeefffggghhh", "33333333333"));
   }

   /**
    * @param operation
    * @param message
    * @param key
    * @return
    */
   public static String channel(int operation, String message, String key) {
      switch (operation) {
         case 1 :
            return encode(message, key);
         case 2 :
            return decode(message, key);
      }

      return null;
   }

   private static String decode(String message, String key) {
      if (key == null || key.isEmpty())
         return message;
      if (message == null || message.isEmpty())
         return message;
      StringBuilder decoded = new StringBuilder();
      int index = 0;
      char[] mes = message.toCharArray();
      for (char k : key.toCharArray()) {
         if (index < mes.length) {
            char en = mes[index];
            int x = Character.getNumericValue(k);
            int p = index + x;
            while(index < p && index < mes.length) {
               if(en == mes[index]) {
                  index++;
               } else {
                  return "-1";
               }
            }
            decoded.append(en);
         }
      }
      while(index < mes.length) {
         decoded.append(mes[index]);
         index++;
      }
      return decoded.toString();
   }

   private static String encode(String message, String key) {
      if (key == null || key.isEmpty())
         return message;
      if (message == null || message.isEmpty())
         return message;

      StringBuilder encoded = new StringBuilder();
      int index = 0;
      char[] mes = message.toCharArray();
      for (char k : key.toCharArray()) {
         if (index < mes.length) {
            char en = mes[index];
            int x = Character.getNumericValue(k);
            for (int i = 0; i < x; i++) {
               encoded.append(en);
            }
            index++;
         } else {
            break;
         }
      }
      if (index < mes.length) {
         for (int i = index; i < mes.length; i++)
            encoded.append(mes[i]);
      }

      return encoded.toString();
   }

   public static String decodeString(String s) {
      Stack<Character> t = new Stack<>();
      for(char c : s.toCharArray()){
          if(c == ']'){
              StringBuilder x = new StringBuilder();
              while(t.peek() != '['){
                  x.append(t.pop());
              }
              t.pop();
              //System.out.println(t.pop() + " " + t.pop());
              int digit = t.pop() - 48;

              StringBuilder y = new StringBuilder();
              for(int i =0; i < digit; i++){
                  y.append(x.toString());
              }
              for(char v : y.toString().toCharArray()){
                  t.push(v);
              }
          } else{
              t.push(c);
          }
      }
      StringBuilder z = new StringBuilder();
      while(!t.isEmpty()){
          z.append(t.pop());
      }
      return z.toString();
  }

   public static int trailingZeroes(int n) {
      int ze = 0;
      while(n >= 5){
          ze  += (n/5);
          n /= 5;
      }
      return ze;
  }
   public static int compress(char[] chars) {
      int i=0;
      int n = chars.length - 1;
      int j =0;
      while(i<chars.length){
         int count = 0;
         while(i < n && chars[i] == chars[i+1]){
         //System.out.println(chars[j] + " " + j + " " + i);
             count++;
             i++;
         }
         chars[j] = chars[i];
         j++;
         if(count > 0){
             count++;
             //System.out.println(chars[j] + " " + j + " " + i);
             int[] dig = new int[count];
             int k =0;
             while(count > 0){
                dig[k++] = count % 10;
                 count = count/10;
             }
             while(k > -1){
                 chars[j] = (char)(dig[k]+'0');
                 j++;
                 k--;
             }
         }
         i++;
     }
      return j-2;
  }
}
