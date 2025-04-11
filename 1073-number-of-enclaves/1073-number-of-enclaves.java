class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    dfs(grid,i,j,n,m);
                }
            }
        }
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)count++;
            }
        }

        return count;
    }

    public void dfs(int[][]grid,int r,int c, int n,int m){
        if(r<0 || c<0 || r>n-1 || c>m-1 || grid[r][c]==0)return;

        grid[r][c]=0;

        dfs(grid,r,c+1,n,m);
        dfs(grid,r+1,c,n,m);
        dfs(grid,r-1,c,n,m);
        dfs(grid,r,c-1,n,m);

    }
}