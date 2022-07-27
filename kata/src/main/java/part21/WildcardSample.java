package part21;

public class WildcardSample {
    public static void main(String[] args) {
        WildcardSample sample = new WildcardSample();
        sample.callWildCardMethod();
    }

    private void callWildCardMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
//        WildcardGeneric<?> wildcard = new WildcardGeneric<String>();
        wildcard.setWildcard("A");
        wildcardStringMethod(wildcard);
    }

    private void wildcardStringMethod(WildcardGeneric<?> wildcard) {
        Object value = wildcard.getWildcard();
        System.out.println(value);
    }

}
