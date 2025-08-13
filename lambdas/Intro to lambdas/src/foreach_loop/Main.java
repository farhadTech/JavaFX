package foreach_loop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> nameList = new ArrayList<String>();
        nameList.add("Fred");
        nameList.add("Barn");
        nameList.add("Richard");
        nameList.add("Jane");
        nameList.add("John");
        nameList.add("Mary");
        nameList.add("Sam");

        for(String name : nameList) {
            System.out.println(name);
        }

        nameList.forEach(
                (names) -> System.out.println(names));
    }
}
