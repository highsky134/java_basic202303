package day08.poly.car;

// 다형성이 필요한 두번째 이유
// 배열을 이종모음구조로 만들수있음
public class CarShop {
    Car[] cars;

//    Mustang[] mustangs;
//    Stinger[] stingers;
//    Tucson[] tucsons;

    // 대리점에 차를 입고하는 기능
    public void importCar() {
//        mustangs = new Mustang[]{
//                new Mustang(),
//                new Mustang(),
//                new Mustang(),
////                new Stinger()
//        }; 동종모음구조인 배열은 다른 종류가 들어갈수 없음

        cars = new Car[]{
                new Mustang(),
                new Mustang(),
                new Mustang(),
                new Stinger(),
                new Stinger(),
                new Tucson()
        };

        // 문자열과 정수와 논리를 배열에 담을 수 있는가?
        Object[] oArr = {
                50, 30, 3.3, "zzzz", false,
                new Mustang()
        };
    }

    // 주행 테스트 기능
    public void runTest() {
        importCar();
        for (Car car: cars){
            car.accelerate();
            // 공통적인 기능을 처리하기 위해 오버라이딩을 하는거다~
        }
    }

    // 차를 고객에게 인도하는 기능
    // 리턴타입에 적용되는 다형성
    public Car exportCar(int money) {
        if (money == 6000) {
            return new Mustang();
        } else if (money == 5000) {
            return new Stinger();
        } else if (money == 3000) {
            return new Tucson();
        } else {
            return null;
        }
    }

}
