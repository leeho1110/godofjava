package part15;

public class MaxSizeOfStringInstance {

    public static void main(String[] args) {
        String a = "test";
        a.length();
    }

    public void addUntilMax(){
        // String instance max size
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                sb.append('a');
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println(i);
                break;
            }
        }
        System.out.println(sb.toString().length());
    }
}
