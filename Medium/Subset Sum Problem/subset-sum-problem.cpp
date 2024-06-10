//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function template for C++

class Solution{   
public:
bool f(int idx,int k,vector<int>&nums,vector<vector<int>>&dp){
    if(k==0)return true;

    if(idx==0)return (nums[0]==k);
      if(dp[idx][k]!=-1)return dp[idx][k];

    bool notTake=f(idx-1,k,nums,dp);

    bool take=false;
    if(nums[idx]<=k){
        take=f(idx-1,k-nums[idx],nums,dp);
    }

    return dp[idx][k]=take | notTake;
}
    bool isSubsetSum(vector<int>nums, int k){
        // code here 
        int n=nums.size();
          vector<vector<int>>dp(n,vector<int>(k+1,-1));
    return f(n-1,k,nums,dp);
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N, sum;
        cin >> N;
        vector<int> arr(N);
        for(int i = 0; i < N; i++){
            cin >> arr[i];
        }
        cin >> sum;
        
        Solution ob;
        cout << ob.isSubsetSum(arr, sum) << endl;
    }
    return 0; 
} 

// } Driver Code Ends