package day08.poly;

public class Main {
    public static void main(String[] args) {

        // 객체는 항상 역할에 의존해야지 구현체에 의존하면 안됨
        // 편의점주는 아르바이트 역할에 의존해야지 홍길동이라는 알바생한테 의존하면 안됨
        Computer com = new Computer();
        LgMonitor lgMonitor = new LgMonitor();

        com.monitor = lgMonitor;

        // 모니터 교환
        com.monitor = new HpMonitor();
        com.monitor = new LgMonitor();
    }
}
