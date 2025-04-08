class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;

        if(n==1){
            return nums[0];
        }else if(nums[0]!=nums[1]){
            return nums[0];
        }else if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }

        int lo=0;
        int hi=n-1;

        while(lo<=hi){
            int mid=(lo+hi)>>1;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])return nums[mid];

            else if(nums[mid]==nums[mid-1]){
                int count=mid-lo+1;

                if((count&1)==0){
                    lo=mid+1;
                }else{
                    hi=mid-2;
                }

            }else if(nums[mid]==nums[mid+1]){
                int count=hi-mid+1;

                if((count&1)==0){
                    hi=mid-1;
                }else{  
                    lo=mid+2;
                }
            }
        }
        
        return -1;
    }
}

//tc --> 0(logn)
//sc --> 0(1)

