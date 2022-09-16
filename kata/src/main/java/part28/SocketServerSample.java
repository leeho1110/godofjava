package part28;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerSample {

    private static final String EXIT = "EXIT";

    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
        sample.startServer();
    }

    public void startServer() {
        ServerSocket server = null;
        Socket client = null;

        try {
            // 요청을 수신할 ServerSocket 생성
            server = new ServerSocket(9999);

            // 수신 대기 상태
            while (true) {
                // accept()를 통해 원격 호출 대기 상태로 돌입, 연결 완료 시 Socket 객체를 리턴
                System.out.println("Server:Waiting for request.");
                client = server.accept();
                System.out.println("Server:Accepted.");

                // 클라이언트가 전송한 데이터를 수신, 만약 클라이언트에게 전송을 원하는 경우 getOutputStream()
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));

                String data = null;
                StringBuilder receivedData = new StringBuilder();
                while((data=in.readLine())!= null){
                    receivedData.append(data);
                }
                System.out.format("Received Data: %s",receivedData);

                // 연결 종료 및 자원 반납
                in.close();
                stream.close();
                client.close();

                // 넘어오는 데이터가 EXIT 문자열인 경우 프로그램을 종료
                if(isExitRequest(receivedData)){
                    System.out.println("\nClient request Stop SocketServer!!");
                    break;
                }
                System.out.println("\n--------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try { server.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

    private boolean isExitRequest(StringBuilder receivedData) {
        return receivedData != null && EXIT.equals(receivedData.toString());
    }
}
