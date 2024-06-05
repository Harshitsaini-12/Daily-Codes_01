class Solution {
    public String getPermutation(int n, int k) {
        List<Integer>number=new ArrayList<>();
        int fact=1;
        String ans="";
        for(int i=1;i<n;i++){
            fact*=i;
            number.add(i);
        }
        number.add(n);
        k=k-1;

        while(true){
            ans=ans+number.get(k/fact);
            number.remove(k/fact);

            if(number.size()==0)break;

            k=k%fact;
            fact=fact/number.size();

        }

        return ans;
    }
}