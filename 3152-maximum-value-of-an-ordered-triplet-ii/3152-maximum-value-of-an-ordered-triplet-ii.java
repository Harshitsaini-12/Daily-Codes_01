class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;

        int []lmax=new int[n];
        int []rmax=new int[n];
        lmax[0]=nums[0];
        rmax[n-1]=nums[n-1];

        for(int i=1;i<=n-3;i++){
            lmax[i]=Math.max(lmax[i-1],nums[i]);
        }
        
        for(int i=n-2;i>=2;i--){
            rmax[i]=Math.max(rmax[i+1],nums[i]);
        }

        long res=0l;
        for(int i=1;i<=n-2;i++){
            res=Math.max(res,(lmax[i-1]-nums[i])*(long)(rmax[i+1]));
        }
        return res;
    }
}