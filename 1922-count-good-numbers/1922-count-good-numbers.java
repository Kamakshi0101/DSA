class Solution {
    static final long MOD = 1000000007;

    public long power(long base, long p) {
        if (p == 0) return 1;

        long temp = power(base, p / 2) % MOD;

        if (p % 2 == 0) {
            return (temp * temp) % MOD;
        } else {
            return (temp * temp % MOD * base) % MOD;
        }
    }

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (power(5, even) * power(4, odd)) % MOD;

        return (int) ans;
    }
}