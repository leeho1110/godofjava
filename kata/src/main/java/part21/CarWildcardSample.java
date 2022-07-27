package part21;

public class CarWildcardSample {
    public static void main(String[] args) {
        CarWildcardSample sample = new CarWildcardSample();
        sample.callBoundWildcardMethod();
        sample.genericMethod(new WildcardGeneric<String>(), "param");
    }

    private void callBoundWildcardMethod() {
        WildcardGeneric<Car> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard(new Car("Mustang"));
        boundedWildcardMethod(wildcard);
    }

    private void boundedWildcardMethod(WildcardGeneric<? extends Car> wildcard) {
        Car car = wildcard.getWildcard();
        System.out.println(car);

        // java: incompatible types: part21.Car cannot be converted to capture#1 of ? extends part21.Car
        // 인자로 들어온 wildCard 매개변수는
        // wildcard.setWildcard(new Car("name"));
    }

    private <T> void genericMethod(WildcardGeneric<T> c, T addValue){
        c.setWildcard(addValue);
        T wildcard = c.getWildcard();
        System.out.println(wildcard);
    }
}
