class Solution {
public:
    int lengthOfLastWord(string s) {
        int count=0;

        for(int i=s.size()-1;i>=0;i--){
            if(count==0 && s[i]==' ')continue;

            if(count!=0 && s[i]==' ')break;

            count++;
        }

        return count;
    }
};