class Counter {
    private int count = 0;
    public synchronized void add(int v) {
        count += v;
    }
    public int get() { return count; }
}
