package part22;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;

public class ListSample {
    public static void main(String[] args) {
        // initialCapacity
        ArrayList<String> strings = new ArrayList<>(100);

        // Shallow Copy & Deep copy
        ArrayList<String> shallow = new ArrayList<>();
        shallow.add("shallow");

        ArrayList<String> shallowCopy = shallow;
        shallowCopy.add("shallow2");

        for (String s : shallow) {
            System.out.println("s = " + s);
        }

        ArrayList<String> deep = new ArrayList<>();
        deep.add("deep");

        ArrayList<String> deepCopy = new ArrayList<>(deep);
        deepCopy.add("deepCopy");

        for (String d : deep) {
            System.out.println("d = " + d);
        }

        // toArray()
        ArrayList<String> untilArrayList = new ArrayList<>();
        untilArrayList.add("until");
        String[] toArray = untilArrayList.toArray(new String[0]);

        for (String s : toArray) {
            System.out.println("s = " + s);
        }

    }
}
