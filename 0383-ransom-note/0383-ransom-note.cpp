class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int cons[26]={0};

        for(auto c:magazine){
            cons[c-'a']++;
        }

        for(auto c:ransomNote){
            if(cons[c-'a']--<=0){
                return false;
            }
        }

        return true;
    }
};