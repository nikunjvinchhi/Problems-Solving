/**
1722. Minimize Hamming Distance After Swap Operations
You are given two integer arrays, source and target, both of length n. You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi (0-indexed) of array source. Note that you can swap elements at a specific pair of indices multiple times and in any order.

The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).

Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source.

 

Example 1:

Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
Output: 1
Explanation: source can be transformed the following way:
- Swap indices 0 and 1: source = [2,1,3,4]
- Swap indices 2 and 3: source = [2,1,4,3]
The Hamming distance of source and target is 1 as they differ in 1 position: index 3.
Example 2:

Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
Output: 2
Explanation: There are no allowed swaps.
The Hamming distance of source and target is 2 as they differ in 2 positions: index 1 and index 2.
Example 3:

Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
Output: 0
 

Constraints:

n == source.length == target.length
1 <= n <= 105
1 <= source[i], target[i] <= 105
0 <= allowedSwaps.length <= 105
allowedSwaps[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
*/
class Solution {
     public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
         
         
         //The idea is to use connected component.
         //Make Graph for allowedSwaps.
         //Index will be the node.
         Map<Integer, List<Integer>> graph = new HashMap<>();
         if(allowedSwaps.length > 0){
            for(int[] x : allowedSwaps){
                graph.putIfAbsent(x[0], new ArrayList<>());
                graph.putIfAbsent(x[1], new ArrayList<>());
                graph.get(x[0]).add(x[1]);
                graph.get(x[1]).add(x[0]);
            }    
         } else{
             for(int i=0; i<source.length;i++){
                 graph.put(i, new ArrayList<>());
             }
         }
                  
         //Do DFS on graph. and Maintain Occurances of 
         //source and target
         int result = 0;
         boolean[] vis = new boolean[source.length];
         for(int i=0; i<source.length;i++){
             if(!vis[i]){
                 Map<Integer, Integer> counter = new HashMap<>();
                 doDfs(i,vis, graph, source, target, counter);
                 for(int key : counter.keySet()){
                     //System.out.println(counter.get(key));
                     result += (counter.get(key) > 0 ? counter.get(key) : 0);
                 }
             }
         }
         return result;
     }
    
    public void doDfs(int vertex, boolean[] vis, Map<Integer, List<Integer>> graph, int[] source, int[] target, Map<Integer, Integer> counter){
       if(vis[vertex])
           return;
        vis[vertex] = true;
        if(counter.containsKey(source[vertex])){
            int x = counter.get(source[vertex]) + 1;
            //System.out.println(x + " " + vertex);
            counter.put(source[vertex], x);
        } else{
            counter.put(source[vertex], 1);
        }
        if(counter.containsKey(target[vertex])){
            int y = counter.get(target[vertex]) - 1;
            //System.out.println(y + " " + vertex);
            counter.put(target[vertex], y);
        } else{
            counter.put(target[vertex], -1);
        }
        if(graph.get(vertex) != null){
            for(int child : graph.get(vertex)){
                doDfs(child, vis, graph, source, target, counter);
            }
        }   
    }
}