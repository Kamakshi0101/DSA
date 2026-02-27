class Solution {
    public double pow(double x, long n)
    {
        if(n==0) return 1;
        if(n==1) return x;

        if(n<0)
        {
            n=-1*n;
            return 1/pow(x,n);
        }
        if(n%2==0)
        {
            double temp= pow(x,n/2);
            return temp*temp;
        }
        double temp= pow(x,n/2);
        return x*temp*temp;
    }
    public double myPow(double x, int n) {
        return pow(x,(long)n);
    }
}