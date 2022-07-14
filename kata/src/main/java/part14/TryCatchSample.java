package part14;

public class TryCatchSample {

    public static void main(String[] args) {
        TryCatchSample sample = new TryCatchSample();
        sample.arrayIdxOOBException();
    }

    public void arrayIdxOOBException() {
        int[] array = new int[5];
        try {
            System.out.println(array[5]);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e.toString() = " + e.toString());
            e.printStackTrace();
        }
    }
}
