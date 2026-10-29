class ArrayRotator {
    public static int[] rotateRight(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return arr;
        k = k % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = arr[i];
        }
        return res;
    }
}
