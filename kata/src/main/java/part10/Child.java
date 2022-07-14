package part10;

public class Child extends Parent {

    public Child() {
        System.out.println("Invoke Child Constructor");
    }

    @Override
    public void publicMethod(){
        super.publicMethod(); // 부모 클래스와 결합도
        System.out.println("and Invoke Child's logic too");
    }

    public static void main(String[] args) {
        Child child = new Child(); // Invoke Parent Constructor // Invoke Child Constructor
        child.publicMethod(); // Invoke Parent's logic \n and Invoke Child's logic too
        System.out.println("child.parentVar1 = " + child.parentVar1); // child.parentVar1 = pv1
        System.out.println("child.parentVar2 = " + child.parentVar2); // child.parentVar2 = pv2

        Parent parentCasting = new Child();
//        Child childCastring = new Parent(); // incompatible types: part10.Parent cannot be converted to part10.Child

        Child childCasting = new Child();
        Parent tempParent = childCasting;
        Child result = (Child) tempParent;

        System.out.println(result instanceof Parent);
    }
}
