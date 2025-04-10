class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p=1;
        int []right=new int[nums.length];

        for(int i=nums.length-1;i>=0;i--){
            p*=nums[i];
            right[i]=p;
        }

        p=1;
        int []res=new int[nums.length];

        for(int i=0;i<nums.length-1;i++){
            int l=p;
            int r=right[i+1];

            res[i]=l*r;
            p*=nums[i];
        }

        res[nums.length-1]=p;

        return res;
    }
}