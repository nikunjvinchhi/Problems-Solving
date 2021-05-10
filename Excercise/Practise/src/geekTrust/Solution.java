package geekTrust;
import java.util.*;
public class Solution {
    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        int t = Integer.parseInt(input.nextLine());
//        
//        for (int ks = 1; ks <= t; ks++) {
//            System.out.println("Case #" + ks + ": " + solve(input));
//        }
    	String s = "1073766625##218949:KY##2000033:1073766626##1073766627:KY##KY:218949##2000033##";
    	removeCycleAndCheckPathValid(s.split("##"));
    	
    	int[] a = {2,0,4,1,2};
    	int[] b = {1,3,0,0,2};
    	advantageCount(a,b);
    }
    
    
    
    public static void removeCycleAndCheckPathValid(String[] odPairs) {
        List<String> t = new LinkedList<>();
        Set<String> pairs = new HashSet<>();
        for (String od : odPairs) {
           pairs.add(od);
           String[] pa = od.split(":");
           if (pa.length == 1) {
              t.add(pa[0]);
           } else {
              t.add(pa[1]);
              t.add(pa[0]);
           }
        }
        //Now this is as good as Linked list which contain a cycle and we have to remove it.
        List<String> finals = new LinkedList<>();
        int found = 0;
        boolean f = false;
        for (int i = 0; i < t.size();) {
           for (int j = i + 1; j < t.size(); j++) {
              if (t.get(i).equals(t.get(j))) {
                 found = j - i;
                 if (found >= 2) {
                    i = j;
                    f = true;
                 }
              }
           }           
           if (!f) {
              finals.add(t.get(i));
              i++;
           } else {
              finals.add(t.get(i));
              finals.add(t.get(i));
              i++;
              f = false;
           }
           if(i >= t.size())
        	   break;
        }
        List<String> finalPairs = new LinkedList<>();
        int i = 0;
        f = false;
        while (i < finals.size()) {
           String a = f == true ? finals.get(i) + ":" + finals.get(i-1) : finals.get(i);
           if (pairs.contains(a)) {
              finalPairs.add(a);
              f = false;
           } else {
              f = true;
           }
           i++;
        }
        System.out.println(finalPairs);
     }
    
    
    public static int solve(Scanner input){
    	String g = input.nextLine();
    	String[] gt = g.split(" ");
        int n = Integer.parseInt(gt[0]);
        int k = Integer.parseInt(gt[1]);
        String s = input.nextLine();
        System.out.println(n + " " + s + " " + k );
        int count=0;
        for(int i=0; i<(n/2); i++){
            if(s.charAt(i) != s.charAt(n-i-1)){
                count++;
            }
        }
        if(count == k){
            return 0;
        }
        if(count < k){
            return k-count;
        }
        if(count > k){
            return count-k;
        }
        return 0;
    }
    
    
    
    public static int[] advantageCount(int[] A, int[] B) {
        // int n = A.length;
        // int m = B.length;
        // Arrays.sort(A);
        // LinkedList<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toCollection(LinkedList::new));
        // List<Integer> ix = new ArrayList<>();
        // for(int i=0; i<m;i++){
        //     boolean y = false;
        //     for(Integer z : list){
        //         if(z > B[i]){
        //             A[i] = z;
        //             y = true;
        //             list.remove(z);
        //             break;
        //         }
        //     }
        //     if(!y){
        //         ix.add(i);
        //     }
        // }
        // for(int in : ix){
        //     A[in] = list.pollFirst();
        // }
        // return A;
        
        Arrays.sort(A);
        int[] x = new int[A.length];
        List<Integer> t = new ArrayList<>();
        int k =0;
        for(int i=0; i<B.length;i++){
            int v = B[i];
            int nex = next(A, v);
            if(nex != -1){
                // System.out.println(A[nex] + " " + v);
                x[i] = A[nex];
                A[nex] = -1;
            } else{
                t.add(i);
            }
        }
        for(int i : A){
            System.out.println(i);
        }
        System.out.println(t);
        for(int in : t){
            for(int i=0; i<A.length;i++){
                if(A[i] != -1){
                    x[in] = A[i];
                    A[i] = -1;
                    break;
                }
            }
        }
        return x;        
    }
    
    
    
    private static int next(int[] arr, int target) 
    { 
        int start = 0, end = arr.length - 1; 
    
        int ans = -1; 
        while (start <= end) { 
            int mid = (start + end) / 2; 
    
            // Move to right side if target is 
            // greater. 
            if (arr[mid] <= target) { 
                start = mid + 1; 
            } 
    
            // Move left side. 
            else { 
                ans = mid; 
                end = mid - 1; 
            } 
        } 
        return ans; 
    } 
}
