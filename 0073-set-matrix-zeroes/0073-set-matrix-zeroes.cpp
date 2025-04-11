class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
         int col1=1;
        int n=matrix.size();
        int m=matrix[0].size();

        for(int i=0;i<n;i++){
            if(matrix[i][0]==0)col1=0;

            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }

        for(int i=matrix.size()-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(col1==0)matrix[i][0]=0;
        }
    }
};