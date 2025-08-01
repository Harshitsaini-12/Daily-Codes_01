class Solution {
public:

    int f(int n,int m,vector<vector<int>>&grid,vector<vector<int>>&dp){
        if(n==0 && m==0)return grid[n][m];
        if(n<0 || m<0)return 1e9;

        if(dp[n][m]!=-1)return dp[n][m];

        int left=grid[n][m] + f(n-1,m,grid,dp);
        int right=grid[n][m] + f(n,m-1,grid,dp);


        return dp[n][m]=min(left,right);
    }

    int minPathSum(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        vector<vector<int>>dp(n,vector<int>(m,-1));
        return f(n-1,m-1,grid,dp);
    }
};