import java.util.*;

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

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        Point2D p1 = new Point2D(sc.nextInt(), sc.nextInt());
        Point2D p2 = new Point2D(sc.nextInt(), sc.nextInt());
        System.out.printf(Locale.US, "Euclidean: %.2f\n", p1.euclideanDistance(p2));
        System.out.println("Manhattan: " + p1.manhattanDistance(p2));
    }
}
