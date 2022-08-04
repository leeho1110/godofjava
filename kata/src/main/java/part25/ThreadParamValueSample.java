package part25;

public class ThreadParamValueSample extends Thread {

    public ThreadParamValueSample(String name) {
        super(name);
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadParamValueSample sample = new ThreadParamValueSample("My name is thread-ho");
        sample.start(); // My name is thread-ho -> ThreadParamValueSample 인스턴스의 새로운 스레드가 할당되어 run()을 수행
        sample.run(); // main -> main 스레드가 수행
    }
}
