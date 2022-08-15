package part14.trywithresource;

public class MyCloseableResource implements AutoCloseable {

    public void doSomething(){
        System.out.println("invoke " + this.getClass().getSimpleName() + ".doSomething()");
    }

    @Override
    public void close() throws Exception {
        System.out.println("invoke " + this.getClass().getSimpleName() + ".close()");
    }

    public static void main(String[] args) throws Exception {
        try(MyCloseableResource resource = new MyCloseableResource()){
            resource.doSomething(); // invoke MyCloseableResource.doSomething()
        } catch (Exception e){
            e.printStackTrace();
        }
        // invoke MyCloseableResource.close() -> try 구문을 빠져나오면서 바로 호출됨
        System.out.println("MyCloseableResource instance is closed?"); // MyCloseableResource instance is closed?
    }
}
