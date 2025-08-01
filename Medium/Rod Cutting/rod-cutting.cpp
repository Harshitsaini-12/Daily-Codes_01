//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution{
  public:
  int f(int idx,int N,int price[],vector<vector<int>>&dp){

	if(idx==0){
		return price[0]*N;
	}

	if(dp[idx][N]!=-1)return dp[idx][N];

	int notTake= 0+ f(idx-1,N,price,dp);
	int take=INT_MIN;
	int rodLength=idx+1;

	if(rodLength<=N){
		take=price[idx] + f(idx,N-rodLength,price,dp);
	}


	return dp[idx][N]=max(take,notTake);
}
    int cutRod(int price[], int n) {
        //code here
        vector<vector<int>>dp(n,vector<int>(n+1,-1));
	return f(n-1,n,price,dp);
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) 
            cin >> a[i];
            
        Solution ob;

        cout << ob.cutRod(a, n) << endl;
    }
    return 0;
}
// } Driver Code Ends