class Solution {
    public int numIslands(char[][] grid) {
        int [][]dir={{1,0},{-1,0},{0,1},{0,-1}};

        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j,dir);
                }
            }
        }
        return count;
    }

    public void dfs(char[][]grid,int r,int c,int [][]dir){
        grid[r][c]='1';

        for(int i=0;i<dir.length;i++){
            int rr=r + dir[r][0];
            int cc=c + dir[r][1];

            if(rr>=0 && cc>grid[0].length && rr<grid.length && cc>=0 && grid[rr][cc]=='1'){
                dfs(grid,rr,cc,dir);
            }
        }
    }
}