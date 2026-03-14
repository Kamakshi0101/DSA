class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n=matrix.size();
        priority_queue<tuple<int,int,int>,vector<tuple<int,int,int>>,greater<tuple<int,int,int>>> minheap;
        for(int i=0;i<n;i++)
        {
            minheap.push({matrix[i][0],i,0});
        }
        for(int count=0;count<k-1;count++)
        {
            auto[val,row,col]=minheap.top();
            minheap.pop();

            if(col+1< matrix[row].size())
            {
                minheap.push({matrix[row][col+1],row,col+1});
            }
        }
        auto [val,row,col]=minheap.top();
        return val;
    }
};