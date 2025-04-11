class Solution {
    public int[] findErrorNums(int[] nums) {
        int[]res={0,0};
        boolean[]arr=new boolean[nums.length+1];

        for(int num:nums){
            if(arr[num]){
                res[0]=num;
            }else{
                arr[num]=true;
            }
        }

        for(int i=1;i<=nums.length;i++){
            if(arr[i]==false){
                res[1]=i;
            }
        }

        return res;
    }
}