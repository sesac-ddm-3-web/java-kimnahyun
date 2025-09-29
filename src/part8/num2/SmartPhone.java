package part8.num2;

public class SmartPhone implements Callable, Messageable, Connectable {
    @Override
    public void call(String number) {
        System.out.println(number + "로 전화를 겁니다.");
    }

    @Override
    public void endCall() {
        System.out.println("통화를 종료합니다.");
    }

    @Override
    public void connectWiFi(String network) {
        System.out.println(network + " 네트워크에 연결되었습니다.");
    }

    @Override
    public void disconnectWiFi() {
        System.out.println("WiFi 연결을 해제했습니다.");
    }

    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println(message + " 메시지를 " + recipient + "에게 전송했습니다.");
    }
}
