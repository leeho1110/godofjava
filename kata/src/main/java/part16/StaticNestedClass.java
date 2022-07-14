package part16;

public class StaticNestedClass {

    private int parentField;
    static int parentField2;

    static class StaticNested{
        private int value=0;

        public void setValue(int value) {
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }

        public void getExternalField(){
//            System.out.println(parentField); // Non-static field 'parentField' cannot be referenced from a static context
            System.out.println(parentField2);
        }
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        StaticNestedClass.StaticNested nestedClass = new StaticNestedClass.StaticNested();
        nestedClass.setValue(3);
        System.out.println("nestedClass.getValue() = " + nestedClass.getValue());
    }
}
