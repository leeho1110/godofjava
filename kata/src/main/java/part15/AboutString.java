package part15;

public class AboutString {

    public static void main(String[] args) {
        String a = "test";
        String b = "test";

        System.out.println("a == b: " + a==b);
        System.out.println("a.equals(b): "+a.equals(b));

        String isNewObj = new String("isNew");
        System.out.println(isNewObj.hashCode());
        String isNewLiteral = "isNew";
        System.out.println(isNewLiteral.hashCode());

    }
}
