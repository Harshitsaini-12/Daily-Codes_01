class Solution {
public:
int f(int idx,vector<int>& coins,int tar,vector<vector<int>>&dp){
    if(idx==0){
        return (tar%coins[0]==0);
    }

    if(dp[idx][tar]!=-1)return dp[idx][tar];

    int notpick=f(idx-1,coins,tar,dp);
    int pick=0;

    if(coins[idx]<=tar){
        pick=f(idx,coins,tar-coins[idx],dp);
    }

    return dp[idx][tar]=pick+notpick;
}



    int change(int amount, vector<int>& coins) {
        int n=coins.size();
        vector<vector<int>>dp(n,vector<int>(amount+1,-1));
    return f(n-1,coins,amount,dp);
    }
};