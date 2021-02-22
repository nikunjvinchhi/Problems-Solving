/**
Problem
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output should be 2. whenre I have two group which have number of 1 is greater then 1.

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["1","0","0","1","0"]
]
Output 1
*/
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int answer =0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if(grid[i][j] == '1'){
                    if(getIsland(grid, i, j) >1){
                        answer += 1;    
                    }
                }
            }
        }
        return answer;
    }
    private int getIsland(char[][] grid, int i, int j){
        if(i < 0)
            return 0;
        if(j < 0)
            return 0;
        if(i >= grid.length)
            return 0;
        if(j >= grid[i].length)
            return 0;
        if(grid[i][j] == '0')
            return 0;
        
        int e = 1;
        grid[i][j] = '0';//it's visited. Make it 0.
        
        int a = getIsland(grid, i, j+1);
        int b = getIsland(grid, i, j-1);
        int c = getIsland(grid, i+1, j);
        int d = getIsland(grid, i-1, j);
        
        return e+a+b+c+d;
    }
}