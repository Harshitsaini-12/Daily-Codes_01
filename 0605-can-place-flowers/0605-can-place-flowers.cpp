class Solution {
public:
    bool canPlaceFlowers(vector<int>& fb, int n) {
        int total=0;

        for(int i=0;i<fb.size() && total<n;i++){
            if(fb[i]==0){
                int next=(i==fb.size()-1)?0:fb[i+1];
                int prev= (i==0)?0:fb[i-1];

                if(next==0 && prev==0){
                    fb[i]=1;
                    total++;
                }
            }
        }
        return total==n;
    }
};