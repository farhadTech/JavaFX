package filter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Product {
    int id;
    String name;
    float price;

    Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "C", 121.5f));
        list.add(new Product(2, "E", 1232.5f));
        list.add(new Product(3, "B", 1872.5f));
        list.add(new Product(4, "F", 1442.5f));
        list.add(new Product(5, "G", 112.5f));

        Stream<Product> filteredData = list.stream().filter(
                product -> product.price > 1000f);

        filteredData.forEach(product -> System.out.println(product.name));
    }
}








