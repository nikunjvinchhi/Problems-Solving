//https://leetcode.com/problems/is-graph-bipartite/
class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] coloring = new boolean[graph.length];
        //colour true and false.
        for(int i=0; i<graph.length;i++){
            if(!vis[i]){
                if(!doDFS(i,graph, vis, coloring, true)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean doDFS(int i, int[][] graph, boolean[] vis, boolean[] coloring, boolean color){
        vis[i] = true;
        coloring[i] = color;
        
        for(int j : graph[i]){
            if(!vis[j]){
                if(!doDFS(j, graph, vis, coloring, !color))
                    return false;
            } else{
                if(coloring[i] == coloring[j]){//both has same color.
                    return false;
                }
            }
        }
        return true;
    }
}