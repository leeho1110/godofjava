package part14.trywithresource;

public class MyCloseableResource2 implements AutoCloseable {

    public void doSomething(){
        System.out.println("invoke " + this.getClass().getSimpleName() + ".doSomething()");
    }

    @Override
    public void close() throws Exception {
        System.out.println("invoke " + this.getClass().getSimpleName() + ".close()");
    }
}
