package multiple_paramerters;

interface Drawable {
    void draw(int width, int height);
}

interface Addable {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Drawable drawable = (width, height) -> {
                System.out.println("Width is: " + width + " Height is: " + height);
        };
        drawable.draw(10, 20);

        Addable addable = (a, b) -> (a + b);
        int sum = addable.add(12, 12);
        System.out.println("Sum is: " + sum);

        Addable addable2 = (int a, int b) -> (a + b);
        int sum2 = addable2.add(32, 10);
        System.out.println("Sum2 is: " + sum2);
    }
}

