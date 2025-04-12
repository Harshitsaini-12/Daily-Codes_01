class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int len=0;
        int count=0;
        int gsi=0;
        int gei=0;
        
        int si=0;
        int ei=0;
        int n=s.size();
        vector<int>freq(128,0);
        
        while(ei<n){
            
            if(freq[s[ei]]==1){
                count++;
            }
            
            freq[s[ei]]++;
            ei++;
            
            while(count>0){
                if(freq[s[si]]==2){
                    count--;
                }
                
                freq[s[si]]--;
                si++;
            }
            
            if(len<ei-si){
                len=ei-si;
                // gsi=si;
                // gei=ei;    
            }
        }
        
        // cout<<s.substr(gsi,gsi+len);
        return len;
    }
};