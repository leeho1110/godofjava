package part8;

public class PassByValueReference {

    public static void main(String[] args) {
        PassByValueReference instance = new PassByValueReference();
        instance.callPassByValue();
    }

    public void callPassByValue() {
        int val=10;
        String ref="b";
        System.out.println("before passByValue");
        System.out.println("val = " + val);
        System.out.println("ref = " + ref);
        passByValue(val,ref);
        System.out.println("after passByValue");
        System.out.println("val = " + val);
        System.out.println("ref = " + ref);
    }

    public void passByValue(int val, String ref) {
        val = 20;
        ref = "z";
        System.out.println("in passByValue");
        System.out.println("val = " + val);
        System.out.println("ref = " + ref);
    }
}
