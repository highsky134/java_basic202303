package day08.poly.car;

// 운전자 객체
public class Driver {

//    public void drive(Mustang m) {
//        System.out.println("운전을 시작합니다.");
//        m.accelerate();
//    }
//    public void drive(Stinger s) {
//        System.out.println("운전을 시작합니다.");
//        s.accelerate();
//    }
//    public void drive(Tucson t) {
//        System.out.println("운전을 시작합니다.");
//        t.accelerate();
//    }
    // 어우.. 운전할 차 종류가 너무 많네
    // 다형성을 이용해서 Car를 상속받는 애들을 Car타입으로 처리해
    public void drive(Car c) {
        System.out.println("운전을 시작합니다.");
        c.accelerate();
    }
}
