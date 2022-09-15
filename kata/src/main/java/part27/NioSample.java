package part27;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioSample {

    public static void main(String[] args) {
        NioSample nioSample = new NioSample();
        nioSample.basicWriteAndRead();
    }

    private void basicWriteAndRead() {
        String fileName = "/Users/leeho/workspace/godofjava-git/kata/src/main/java/part27/nio.txt";

        try {
            writeFile(fileName, "NIO Sample");
            readFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String fileName, String data) throws IOException {
        FileChannel channel = new FileOutputStream(fileName).getChannel();
        channel.write(ByteBuffer.wrap(data.getBytes()));
        channel.close();
    }

    private void readFile(String fileName) throws IOException {
        FileChannel channel = new FileInputStream(fileName).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }
        channel.close();
    }

}
