class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;

        int[]dp=new int[n+1];
        int[]count=new int[n+1];

        int maxCount=0;
        int maxLen=0;

        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    if(1+dp[j]>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[i]==dp[j]+1){
                        count[i]+=count[j];
                    }
                }
            }

            if(maxLen==dp[i])maxCount+=count[i];
            else if(maxLen<dp[i]){
                maxLen=dp[i];
                maxCount=count[i];
            }




        }
        return maxCount;
    }
}
