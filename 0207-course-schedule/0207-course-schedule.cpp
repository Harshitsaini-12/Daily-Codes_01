class Solution {
public:
    bool canFinish(int n, vector<vector<int>>& p) {
        vector<vector<int>>graph(n);
        vector<int>indegree(n,0);

        for(auto edge:p){
            graph[edge[0]].push_back(edge[1]);
            indegree[edge[1]]++;
        }

        queue<int>q;
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.push(i);
        }

        int vertexCount=0;

        while(!q.empty()){
            int size=q.size();

            while(size-->0){
                int v=q.front();
                q.pop();

                vertexCount++;
                for(auto vtx:graph[v]){
                    if(--indegree[vtx]==0){
                        q.push(vtx);
                    }
                }

            }
        }

        return vertexCount==n;
    }
};