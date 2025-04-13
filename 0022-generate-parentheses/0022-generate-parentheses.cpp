class Solution {
public:

    void helper(int oc,int cc,int n,vector<string>&ans,string s){
        if(oc==n && cc==n){
            ans.push_back(s);
            return;
        }

        if(oc<n){
            helper(oc+1,cc,n,ans,s+"(");
        }

        if(cc<oc){
            helper(oc,cc+1,n,ans,s+")");
        }
    }


    vector<string> generateParenthesis(int n) {
        vector<string>ans;

        int oc=0;
        int cc=0;

        helper(oc,cc,n,ans,"");

        return ans;
    }
};