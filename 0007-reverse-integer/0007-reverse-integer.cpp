class Solution {
public:
    int reverse(int x) {
        long ans=0;

        while(x!=0){
            int d=x%10;
            x/=10;

            ans=ans*10+d;
        }

        if(ans>INT_MAX || ans<INT_MIN)return 0;

        return ans;
    }
};