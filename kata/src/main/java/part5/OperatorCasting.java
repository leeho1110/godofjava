package part5;

public class OperatorCasting {

    public static void main(String[] args) {
        OperatorCasting operatorCasting = new OperatorCasting();
        operatorCasting.casting();
    }

    public void casting() {
        byte byteValue = 127;
        short shortValue = byteValue;

        shortValue++;
        System.out.println(shortValue); // 128, 0000000010000000
        byteValue=(byte)shortValue;
        System.out.println(byteValue);  // -128, 앞자리의 00000000을 날린다
    }
}
