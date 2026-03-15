import java.util.*;

class Fancy {

    private static final long MOD = 1000000007;
    private List<Long> list;
    private long mul;
    private long add;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {
        long x = (val - add + MOD) % MOD;
        x = (x * modInverse(mul)) % MOD;
        list.add(x);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;

        long val = list.get(idx);
        val = (val * mul) % MOD;
        val = (val + add) % MOD;

        return (int) val;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long result = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                result = (result * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }
}