package part23;

import java.util.HashSet;
import java.util.Set;

public class HashSetSample {
    public static void main(String[] args) {
        int carKinds = HashSetSample.getCarKinds(new String[]{"car1", "car2", "car2", "car3"});
        System.out.println("carKinds = " + carKinds); // 3
    }

    public static int getCarKinds(String[] cars){
        if(cars == null){
            return 0;
        }
        if(cars.length == 1){
            return 1;
        }

        Set<String> carSet = new HashSet<>();
        for (String car : cars) {
            carSet.add(car);
        }

        return carSet.size();
    }
}
