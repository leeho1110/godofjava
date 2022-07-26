package part20;

public class JavaLangSystemPrint {
    public static void main(String[] args) {
        JavaLangSystemPrint javaLangSystem = new JavaLangSystemPrint();
        javaLangSystem.printNull();
    }

    private void printNull() {
        Object nullObj = null;
        System.out.println(nullObj); // println은 String.valueOf 메서드를 호출한 결과를 출력한다
        System.out.println(nullObj.toString());
    }
}
