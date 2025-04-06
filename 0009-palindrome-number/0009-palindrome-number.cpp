class Solution {
public:
    bool isPalindrome(int x) {
         long long int ans=0;

        long long int temp=x;

        while(temp>0){
            int dig=temp%10;
            ans=ans*10+dig;

            temp/=10;
        }

        if(x==ans)return true;
        else return false;
    }
};