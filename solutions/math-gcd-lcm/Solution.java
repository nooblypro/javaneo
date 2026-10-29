class MathUtil {
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        long g = gcd(a, b);
        return (a / g) * b;
    }
}
