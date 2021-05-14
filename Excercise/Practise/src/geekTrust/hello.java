package com.gtnexus.tms.rating.businesslogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class hello {


   public static void main(String[] args) throws IOException, ParseException {
      System.out.println(getCountries("uni", 300));
      /*
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter wr = new PrintWriter(System.out);
      int N = Integer.parseInt(br.readLine().trim());
      String[] arr_A = br.readLine().split(" ");
      long[] A = new long[N];
      for (int i_A = 0; i_A < arr_A.length; i_A++) {
         A[i_A] = Long.parseLong(arr_A[i_A]);
      }
      int K = Integer.parseInt(br.readLine().trim());

      long[] out_ = solve(N, A, K);
      System.out.print(out_[0]);
      for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
         System.out.print(" " + out_[i_out_]);
      }

      wr.close();
      br.close();*/
   }

   static int getCountries(String s, int p) throws ClientProtocolException, IOException, ParseException {
      JSONObject rateJson = getCount(s, p, 0);
      int totalCount = 0;

      totalCount = getCountryCount(rateJson, p);
      if (rateJson != null && Integer.valueOf(rateJson.get("total_pages").toString()) > 1) {
         int noOfPages = Integer.valueOf(rateJson.get("total_pages").toString());
         List<JSONObject> hello = new ArrayList<JSONObject>();
         for (int i = 2; i <= noOfPages; i++) {
            JSONObject temp = getCount(s, p, i);
            if (temp != null)
               hello.add(temp);
         }
         if (hello != null && hello.size() > 0) {
            for (JSONObject temp : hello)
               totalCount += getCountryCount(temp, p);
         }
      }
      return totalCount;
   };
   private static int getCountryCount(JSONObject rateJson, int p) {
      int count = 0;
      JSONArray temp = (JSONArray)rateJson.get("data");
      if (temp != null && temp.size() > 1) {
         for (int i = 0; i < temp.size(); i++) {
            JSONObject country = (JSONObject)temp.get(i);
            if (country.get("population") != null) {
               String population = country.get("population").toString();
               if (Integer.valueOf(population) > p) {
                  count++;
               }
            }
         }
      }
      return count;
   }

   public static JSONObject getCount(String s, int p, int pagenumbr) throws ClientProtocolException, IOException, ParseException {
      HttpGet request = null;

      CloseableHttpClient httpClient = HttpClients.createDefault();
      if (pagenumbr == 0)
         request = new HttpGet("https://jsonmock.hackerrank.com/api/countries/search?name=" + s);
      else
         request = new HttpGet("https://jsonmock.hackerrank.com/api/countries/search?name=" + s + "&page=" + pagenumbr);
      try (CloseableHttpResponse response = httpClient.execute(request)) {
         HttpEntity entity = response.getEntity();
         if (entity != null) {
            // return it as a String
            String result = EntityUtils.toString(entity);
            JSONParser parser = new JSONParser();
            JSONObject rateJson = (JSONObject)parser.parse(result);
            return rateJson;
         }
      }
      return null;
   }

   static long[] solve(int N, long[] A, int K) {
      // Write your code here
      long[] hello = new long[K + 1];
      for (int i = 0; i <= K; i++) {
         hello[i] = xorPairCount(A, i);
      }
      return hello;
   }

   static long xorPairCount(long arr[], int x) {
      long result = 0; // Initialize result
      Map<Long, Integer> m = new HashMap<>();

      for (int i = 0; i < arr.length; i++) {
         long curr_xor = x ^ arr[i];
         if (m.containsKey(curr_xor))
            result += m.get(curr_xor);

         // Increment count of current element
         if (m.containsKey(arr[i])) {
            m.put(arr[i], m.get(arr[i]) + 1);
         } else {
            m.put(arr[i], 1);
         }
      }
      // return total count of pairs with XOR equal to x
      return result;
   }
}