package part27;

import java.nio.IntBuffer;

public class NioDetailSample {
    public static void main(String[] args) {
        NioDetailSample sample = new NioDetailSample();
        sample.checkBuffer();
        sample.checkBufferStatus();
    }

    private void checkBuffer() {
        try {
            IntBuffer buffer = IntBuffer.allocate(1024);
            for (int i = 0; i < 100; i++) {
                buffer.put(i);
            }

            System.out.println("Buffer capacity="+buffer.capacity());
            System.out.println("Buffer limit="+buffer.limit());
            System.out.println("Buffer position="+buffer.position());

            buffer.flip(); // limit을 현재 position으로 끌어오기

            System.out.println("Buffer flipped!!");
            System.out.println("Buffer limit=" + buffer.limit());
            System.out.println("Buffer position="+buffer.position());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void checkBufferStatus(){
        try {
            IntBuffer buffer = IntBuffer.allocate(1024);

            buffer.get();
            printBufferStatus("get", buffer);

            buffer.mark();
            printBufferStatus("makr", buffer);

            buffer.get();
            printBufferStatus("get", buffer);

            buffer.reset();
            printBufferStatus("reset", buffer);

            buffer.rewind();
            printBufferStatus("rewind", buffer);

            buffer.clear();
            printBufferStatus("clear", buffer);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void printBufferStatus(String job, IntBuffer buffer){
        System.out.println("Buffer "+job);
        System.out.format("Buffer position=%d remaining=%d limit=%d\n", buffer.position(), buffer.remaining(), buffer.limit());
    }
}
