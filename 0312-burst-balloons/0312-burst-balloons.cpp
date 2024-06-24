class Solution {
public:

int f(int i,int j,vector<int>&a,vector<vector<int>>&dp){
	if(i>j)return 0;
	int maxi=-1e8;

	if(dp[i][j]!=-1)return dp[i][j];

	for(int cut=i;cut<=j;cut++){
       int minamount=a[i-1]*a[cut]*a[j+1] + f(i,cut-1,a,dp) + f(cut+1,j,a,dp);
	   maxi=max(maxi,minamount);
	}

	return dp[i][j]=maxi;
}

    int maxCoins(vector<int>& a) {
            int n=a.size();
            a.push_back(1);
            a.insert(a.begin(),1);
            vector<vector<int>>dp(n+1,vector<int>(n+1,-1));

            return f(1,n,a,dp);
    }
};