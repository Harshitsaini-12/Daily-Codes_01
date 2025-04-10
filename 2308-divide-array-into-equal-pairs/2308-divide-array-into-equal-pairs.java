class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();

        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        for(int key:hm.keySet()){
            if(hm.get(key)%2!=0)return false;
        }

        return true;
    }
}