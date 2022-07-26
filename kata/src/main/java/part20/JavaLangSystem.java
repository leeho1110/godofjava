package part20;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaLangSystem {

    public static void main(String[] args) {
        JavaLangSystem javaLangSystem = new JavaLangSystem();
        javaLangSystem.systemPropertiesCheck();
    }

    private void systemPropertiesCheck() {
        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
            System.out.println("entry." + entry.getKey() + "= " + entry.getValue());
        }
    }

}
