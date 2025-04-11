class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count=1;
        int val=nums[0];

        for(int i=1;i<nums.size();i++){
            if(nums[i]==val){
                count++;
            }else{
                count--;
            }

            if(count==1){
                count=1;
                val=nums[i];
            }
        }
        return val;
    }
};