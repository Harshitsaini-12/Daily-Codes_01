class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int no=0;
        int count=0;

        for(int i=0;i<nums.size();i++){
            if(nums[i]!=val){
                nums[no++]=nums[i];
            }else{
                count++;
            }
        }

        return nums.size()-count;
    }
};