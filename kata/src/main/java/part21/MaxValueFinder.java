package part21;

public class MaxValueFinder {
    public void testGetMax(){
        System.out.println(getMax(1,2,3));
        System.out.println(getMax(3,1,2));
        System.out.println(getMax(2,3,1));
    }

    public void testGetMin(){
        System.out.println(getMin(1,2,3));
        System.out.println(getMin(3,1,2));
        System.out.println(getMin(2,3,1));
    }

    private <T extends Comparable<T>> T getMax(T ... param) {
        T max = param[0];

        for (T temp : param) {
            if(temp.compareTo(max) > 0){ // this(temp)가 max보다 크다면 1을 반환
                max = temp;
            }
        }

        return max;
    }

    private <T extends Comparable<T>> T getMin(T ... param){
        T min = param[0];

        for (T temp : param) {
            if(temp.compareTo(min) < 0){ // this(temp)가 min보다 작다면 -1 반환
                min = temp;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MaxValueFinder finder = new MaxValueFinder();
        finder.testGetMax();
        finder.testGetMin();
    }
}
