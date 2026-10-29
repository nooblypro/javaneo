class Point2D {
    private int x, y;
    public Point2D(int x, int y) { this.x = x; this.y = y; }
    public double euclideanDistance(Point2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public int manhattanDistance(Point2D other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }
}
