class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        
        unordered_map<int,int>mp;
        mp[0]=1;
        int presum=0;
        int ans=0;
        
        for(int i=0;i<nums.size();i++){
            int val=nums[i];
            
            presum+=val;
            
            if(mp.find(presum-k)!=mp.end()){
                ans+=mp[presum-k];
            }
            
            if(mp.find(presum)!=mp.end()){
                mp[presum]++;
            }else{
                mp[presum]=1;
            }
            
        }
        return ans;
    }
};