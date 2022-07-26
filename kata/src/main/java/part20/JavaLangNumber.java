package part20;

public class JavaLangNumber {

    public static void main(String[] args) {
        JavaLangNumber javaLangNumber = new JavaLangNumber();
        javaLangNumber.wrapperClassCanUsedLikePrimitiveType();
        javaLangNumber.checkMinMaxValueOfEachWrapperClass();
        javaLangNumber.checkBinaryDigitOfMinMaxValue();
    }

    public void wrapperClassCanUsedLikePrimitiveType(){
        String value1 = "3";
        String value2 = "5";

        byte b1 = Byte.parseByte(value1);
        byte b2 = Byte.parseByte(value2);
        System.out.println(b1+b2);

        Integer refInt1 = Integer.valueOf(value1); // 3
        Integer refInt2 = Integer.valueOf(value2); // 5
        System.out.println(refInt1+refInt2+"7"); // 참조형은 +연산이 String 빼곤 불가능할텐데? Integer 클래스는 참조형인데?
    }

    public void checkMinMaxValueOfEachWrapperClass(){
        System.out.println("Integer min="+Integer.MIN_VALUE+" max=" + Integer.MAX_VALUE);
        System.out.println("Float min="+Float.MIN_VALUE+" max=" + Float.MAX_VALUE);
        System.out.println("Double min="+Double.MIN_VALUE+" max=" + Double.MAX_VALUE);
    }

    public void checkBinaryDigitOfMinMaxValue(){
        System.out.println("Integer BINARY min="+Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("Integer BINARY max="+Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("Integer HEX min="+Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("Integer HEX max="+Integer.toBinaryString(Integer.MAX_VALUE));
    }
}
