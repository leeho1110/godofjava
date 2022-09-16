# Part 28. 다른 서버로 데이터를 보내려면 어떻게 하면 되나요?

### 개요

기본적으로 우리가 사용하는 인터넷에서 가장 가까운 네트워크 레이어는 애플리케이션 레이어(HTTP)입니다. 그리고 이는 트랜스포트 레이어(TCP) 기반으로 동작하죠. 자바에서는 트랜스포트 레이어를 통해 네트워크 I/O를 수행할 때 필요한 기능을 지원해줍니다. 이번 장에선 소켓에 대해서 알아봅니다.

---

### Socket이란?

- 소켓은 네트워크 위에서 동작하는 두 프로그램 간의 양방향 통신 링크의 엔드포인트에 바인딩된 프로그램를 말합니다. 일반적으로 양방향 통신 링크의 엔드포인트는 우리가 사용하는 인터넷에서의 클라이언트와 서버를 말합니다.
- [java.net](http://java.net) 패키지에서는 소켓 구현체를 Socket, ServetSocket 클래스로 제공합니다.
    - 자바의 Socket 클래스는 양쪽의 연결 상태를 보관합니다.
    - 서버쪽은 ServerSocket, 클라이언트는 Socket 클래스를 통해 Socket 객체를 생성합니다.
    
    > *By using the `java.net.Socket` class instead of relying on native code, your Java programs can communicate over the network in a platform-independent fashion.
    `java.net.Socket` 클래스를 사용하면 네이티트 코드를 사용하지 않고도 플랫폼 독립적인 방식으로 네트워크 통신이 가능합니다.*
    > 
- 위 클래스의 실제 동작은 내부적으로 `SocketImpl` 구현체의 인스턴스가 처리합니다.