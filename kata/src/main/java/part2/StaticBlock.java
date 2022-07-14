package part2;

public class StaticBlock {

    static {
        System.out.println("Execute Static block");
    }

    public static void main(String[] args) {
        System.out.println("Execute Main block");
    }
}
