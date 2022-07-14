package part14;

public class MyExceptionRuntime extends RuntimeException {

    public MyExceptionRuntime() {
    }

    public MyExceptionRuntime(String message) {
        super(message);
    }

    public static void main(String[] args) {
        throw new MyExceptionRuntime("I don't need try-catch or throws");
    }
}
