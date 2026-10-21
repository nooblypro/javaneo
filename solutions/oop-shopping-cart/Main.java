import java.util.*;

class Item {
    private String name;
    private double price;
    private int qty;
    public Item(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
    public double getTotal() { return price * qty; }
}

class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    public void addItem(Item it) { items.add(it); }
    public double getSubtotal() {
        double sum = 0.0;
        for (Item it : items) sum += it.getTotal();
        return sum;
    }
    public double getDiscount() {
        double sub = getSubtotal();
        return sub >= 100.0 ? sub * 0.10 : 0.0;
    }
    public double getFinalTotal() {
        return getSubtotal() - getDiscount();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        ShoppingCart cart = new ShoppingCart();
        for (int i = 0; i < n; i++) {
            cart.addItem(new Item(sc.next(), sc.nextDouble(), sc.nextInt()));
        }
        System.out.printf(Locale.US, "Subtotal: $%.2f\n", cart.getSubtotal());
        System.out.printf(Locale.US, "Discount: $%.2f\n", cart.getDiscount());
        System.out.printf(Locale.US, "Total: $%.2f\n", cart.getFinalTotal());
    }
}
