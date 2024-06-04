class Solution {
    public void helper_combination(int index,int[]arr,int tar,List<List<Integer>>ans,List<Integer>ds){
        if(tar==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])continue;
            if(tar<arr[i])break;

            ds.add(arr[i]);
            helper_combination(i+1,arr,tar-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(candidates);

        helper_combination(0,candidates,target,ans,new ArrayList<>());


        return ans;
    }
}