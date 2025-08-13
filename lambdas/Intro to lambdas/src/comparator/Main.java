package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        // Adding Products
        list.add(new Product(3, "C", 12.5f));
        list.add(new Product(5, "E", 12.5f));
        list.add(new Product(2, "B", 12.5f));
        list.add(new Product(1, "A", 12.5f));
        list.add(new Product(4, "D", 12.5f));

//        list.sort((p1, p2) -> {
//            return p1.name.compareTo(p2.name);
//        });

        System.out.println("Before sorting");
        for(Product p : list) {
            System.out.println(p.id + " " + p.name + " " + p.price);
        }

        list.sort(Comparator.comparing(p -> p.name));

        System.out.println("After sorting: ");
        for(Product p : list) {
            System.out.println(p.id + " " + p.name + " " + p.price);
        }
    }
}
