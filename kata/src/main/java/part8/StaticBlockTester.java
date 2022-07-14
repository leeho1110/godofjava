package part8;

public class StaticBlockTester {

    public static void main(String[] args) {
        StaticBlockTester tester = new StaticBlockTester();
        tester.makeStaticBlockObj();
    }

    public void makeStaticBlockObj() {
        System.out.println("Creating block1 Start");
        StaticBlock block1 = new StaticBlock();
        System.out.println(StaticBlock.getData());
        System.out.println("Creating block1 End");
        System.out.println();
        System.out.println("Creating block2 Start");
        StaticBlock block2 = new StaticBlock();
        System.out.println(StaticBlock.getData());
        System.out.println("Creating block2 End");
    }
}
