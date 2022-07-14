package part14;

public class MyExceptionChecked extends Exception {
    public MyExceptionChecked() {
        super();
    }

    public MyExceptionChecked(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Throw MyException test");
            throw new MyExceptionChecked();
        } catch (MyExceptionChecked e){
            e.printStackTrace();
        }
    }
}
