package part8;

public class StaticBlock {

    static int data=1;

    public StaticBlock() {
        System.out.println("Invoke Constructor");
    }

    static {
        System.out.println("Invoke First Static block");
        data=3;
    }

    static {
        System.out.println("Invoke Second Static block");
        data = 5;
    }

    public static int getData(){
        return data;
    }

}
