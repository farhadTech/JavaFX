package multiple_statements;

interface Speakable {
    String speak(String message);
}

public class Main {
    public static void main(String[] args) {
        Speakable speakable = (message) -> {
            String message1 = "Hello World";
            return message + " " + message1 + " Another message.";
        };
        System.out.println(speakable.speak("Here it goes.."));
    }
}
