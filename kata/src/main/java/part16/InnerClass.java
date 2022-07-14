package part16;

public class InnerClass {

    public void makeAnonymous(Anonymous anonymous) {
    }

    class InnerClassSample {}

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        InnerClass.InnerClassSample innerClassSample = innerClass.new InnerClassSample();

        innerClass.makeAnonymous(new Anonymous() {
            @Override
            public void doSomething() {
            }
        });
    }

}
