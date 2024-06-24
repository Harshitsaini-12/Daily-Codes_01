class Solution {
public:
    int f(int idx,vector<int>&arr,int k,int n,vector<int>&dp){
        if(idx==n)return 0;


        int maxAns=INT_MIN;
        int len=0;
        int maxElem=0;

        if(dp[idx]!=-1)return dp[idx];

        for(int i=idx;i<min(idx+k,n);i++){
            maxElem=max(maxElem,arr[i]);
            len++;
            int sum=len*maxElem + f(i+1,arr,k,n,dp);
            maxAns=max(maxAns,sum);
        }

        return dp[idx]=maxAns;
    }


    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        
        int n=arr.size();
        vector<int>dp(n+1,-1);
        return f(0,arr,k,n,dp);
    }
};