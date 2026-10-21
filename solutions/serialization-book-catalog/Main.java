import java.io.*;
import java.util.*;

class Book implements Serializable, Comparable<Book> {
    private static final long serialVersionUID = 1L;
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }

    @Override
    public int compareTo(Book o) {
        return Double.compare(this.price, o.price);
    }
}

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        ArrayList<Book> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Book(sc.next(), sc.nextDouble()));
        }
        File file = new File("books.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
        }
        ArrayList<Book> loaded;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            loaded = (ArrayList<Book>) ois.readObject();
        }
        Collections.sort(loaded);
        for (Book b : loaded) {
            System.out.printf(Locale.US, "%s: $%.2f\n", b.getTitle(), b.getPrice());
        }
    }
}
