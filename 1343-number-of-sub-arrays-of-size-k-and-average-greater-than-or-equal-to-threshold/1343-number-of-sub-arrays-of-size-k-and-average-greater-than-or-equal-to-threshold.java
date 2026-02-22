class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int maxt=threshold*k;
        int sum=0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }
        int count=0;
        if(sum>=maxt) count++;

        for(int i=k;i<arr.length;i++)
        {
            sum+=arr[i];
            sum-=arr[i-k];
             if(sum>=maxt) count++;
        }
        return count;
    }
}