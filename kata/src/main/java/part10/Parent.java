package part10;

public class Parent {

    public String parentVar1 = "pv1";
    protected String parentVar2 = "pv2";

    public Parent() {
        System.out.println("Invoke Parent Constructor");
    }

    public void publicMethod(){
        System.out.println("Invoke Parent's logic");
    }
}
