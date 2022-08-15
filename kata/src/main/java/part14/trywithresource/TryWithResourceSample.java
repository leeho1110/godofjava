package part14.trywithresource;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResourceSample {
    public static void main(String[] args) throws IOException {
        pracWithBufferedInputStream();
        pracWithAutoCloseableResource();
    }

    private static void pracWithAutoCloseableResource() {
        try(
                MyCloseableResource resource = new MyCloseableResource();
                MyCloseableResource2 resource2 = new MyCloseableResource2();

        ){
            resource.doSomething(); // invoke MyCloseableResource.doSomething()
            resource2.doSomething();

        } catch (Exception e){
            e.printStackTrace();
        }
        // invoke MyCloseableResource2.close()
        // invoke MyCloseableResource.close() -> 나중에 선언된 순대로 반환되며, try 구문을 빠져나오면서 바로 반환

        System.out.println("Closeable instances are all closed?"); // Closeable instances are all closed?
    }

    private static void pracWithBufferedInputStream() {
        try( BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./src/main/java/part14/trywithresource/sample.txt"));) {

            int bufSize = bis.available(); //읽어올 수 있는 byte의 수를 반환한다.
            byte[] buf = new byte[bufSize]; //bufSize 만큼의 byte 배열을 선언한다.

            bis.read(buf);
            System.out.println(new String(buf)); //바이트 배열을 문자열로 변환한 값을 출력한다.

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
