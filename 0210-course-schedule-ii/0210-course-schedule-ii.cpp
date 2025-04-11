class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>>& p) {
         vector<vector<int>>graph(n);
        vector<int>indegree(n,0);

        for(auto edge:p){
            graph[edge[1]].push_back(edge[0]);
            indegree[edge[0]]++;
        }

        queue<int>q;
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.push(i);
        }
        vector<int>ans;

        int vertexCount=0;

        while(!q.empty()){
            int size=q.size();

            while(size-->0){
                int v=q.front();
                q.pop();

                ans.push_back(v);
                for(auto vtx:graph[v]){
                    if(--indegree[vtx]==0){
                        q.push(vtx);
                    }
                }

            }
        }

        if(n!=ans.size()) ans.clear();

        return ans;
    }
};