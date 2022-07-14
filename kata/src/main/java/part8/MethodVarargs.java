package part8;

public class MethodVarargs {

    public static void main(String[] args) {
        MethodVarargs methodVarargs = new MethodVarargs();
        System.out.println(methodVarargs.calculateNumbersWithArray(new int[]{1,2,3,4,5})); // 15
        System.out.println(methodVarargs.calculateNumbers(1,2,3,4,5)); // 15
    }

    public int calculateNumbersWithArray(int[] numbers) {
        int total=0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public int calculateNumbers(int ... numbers){
        int total=0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
