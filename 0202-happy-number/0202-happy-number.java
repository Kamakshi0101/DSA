class Solution {
    public int sum(int n)
    {
        int sum=0;
        while(n>0)
        {
            int dig= n%10;
            sum+=(dig*dig);
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        while(fast!=1)
        {
            slow= sum(slow);
            fast= sum(sum(fast));

            if(fast==1) return true;
            if(fast==slow) return false;
        }
        return true;
    }
}