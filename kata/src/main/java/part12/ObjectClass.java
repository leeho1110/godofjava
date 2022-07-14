package part12;

public class ObjectClass {

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println("object.toString() = " + object);
        System.out.println("object.toString() = " + object.toString());
        System.out.println("object.hashCode() = " + object.hashCode());
    }
}
