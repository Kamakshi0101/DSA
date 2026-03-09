class Solution {
    int count;
    int[] copy;
    public void merge(int[] nums,int l,int mid,int r)
    {
        int i=l,j=mid+1;
        while(i<=mid && j<=r)
        {
            if((long)nums[i]>2*(long)nums[j])
            {
                count+= mid-i+1;
                j++;
            }
            else i++;
        }
        int itr=l;
        i=l;
        j=mid+1;
        while(i<=mid && j<=r)
        {
            if(nums[i]<=nums[j])
            {
                copy[itr++]= nums[i];
                i++;
            }
            else
            {
                copy[itr++]=nums[j];
                j++;
            }
        }
        while(i<=mid) copy[itr++]=nums[i++];
        while(j<=r) copy[itr++]=nums[j++];
        for(int k=l;k<=r;k++)
        {
            nums[k]=copy[k];
        }
    }
    public void merge_sort(int[] nums, int l,int r)
    {
        if(l==r) return;
        int mid= l+(r-l)/2;
        merge_sort(nums,l,mid);
        merge_sort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        count=0;
        copy= new int[n];
        merge_sort(nums,0,n-1);
        return count;
    }
}