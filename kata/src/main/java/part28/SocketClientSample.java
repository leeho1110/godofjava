package part28;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;

public class SocketClientSample {

    private static final String EXIT = "EXIT";

    public static void main(String[] args) {
        SocketClientSample sample=new SocketClientSample();
        sample.sendSocketSample();
    }

    public void sendSocketSample() {
        for(int loop=0;loop<3;loop++) {
            sendSocketData("Send Data at " + LocalDateTime.now());
        }
        sendSocketData(EXIT);
    }

    public void sendSocketData(String data) {
        Socket socket=null;

        try {
            // localhost(127.0.0.1) 9999 포트에 열어놓은 소켓에 접속할 클라이언트 소켓을 생성
            System.out.println("Client:Connecting");
            socket=new Socket("127.0.0.1",9999); // 1)
            System.out.println("Client:Connect status="+socket.isConnected());

            Thread.sleep(1000);
            OutputStream stream=socket.getOutputStream();

            BufferedOutputStream out= new BufferedOutputStream(stream);
            out.write(data.getBytes());
            System.out.format("Client:send data [%s]\n",data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(socket!=null) {
                try { socket.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
    }
}
