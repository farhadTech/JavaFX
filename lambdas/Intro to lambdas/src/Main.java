interface Drawable {
    void draw();
}

interface Rectangle {
    void area();
}

public class Main {
    public static void main(String[] args) {
        // Without using lambda expression
        System.out.println("Without using lambda expression: ");
        Drawable drawable = new Drawable() {

            @Override
            public void draw() {
                System.out.println("Drawing");
            }
        };
        drawable.draw();

        int height = 5;
        Rectangle rectangle = new Rectangle() {

            @Override
            public void area() {
                System.out.println("Area of Rectangle is: " + height * 2);
            }
        };
        rectangle.area();

        // Using lambda expression
        System.out.println("Using lambda expression: ");
        Drawable drawable2 = () -> {
            System.out.println("Drawing");
        };
        drawable2.draw();

        Rectangle rectangle2 = () -> {
            System.out.println("Area of rectangle is: " + height * 2);
        };
        rectangle2.area();
    }
}
