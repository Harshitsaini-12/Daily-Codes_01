class Solution {

    public void helper_combination(int index,List<List<Integer>>ans,int[]arr, int tar,List<Integer>ds){
        if(index==arr.length){
            if(tar==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
     
     //take the element
     if(arr[index]<=tar){
        ds.add(arr[index]);
        helper_combination(index,ans,arr,tar-arr[index],ds);
        ds.remove(ds.size()-1);
     }

     //not take the element
     helper_combination(index+1,ans,arr,tar,ds);


    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();

        helper_combination(0,ans,candidates,target,new ArrayList<>());

        return ans;
    }
}