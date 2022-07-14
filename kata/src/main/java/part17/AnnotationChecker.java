package part17;

import java.lang.reflect.Method;

public class AnnotationChecker {

    @UserAnnotation(number = 1)
    public void doSomething(){
    }

    public void checkAnnotation(Class useClass){
        Method[] methods = useClass.getDeclaredMethods();
        for (Method templateMethod : methods) {
            UserAnnotation annotation = templateMethod.getAnnotation(UserAnnotation.class);
            if(annotation != null){
                int number = annotation.number();
                String text = annotation.text();

                System.out.println("number = " + number);
                System.out.println("text = " + text);
            }
        }
    }

    public static void main(String[] args) {
        AnnotationChecker annotationChecker = new AnnotationChecker();
        annotationChecker.checkAnnotation(AnnotationChecker.class);

    }
}
