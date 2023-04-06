package day09.final_;

class SmartBagPack extends BagPack{
    public SmartBagPack(int size, String brand) {
        super(size, brand);
    }

    @Override
    void getItem() {
        super.getItem();
    }

//    @Override
//    void putItem() {
//
//    }

}
class BagPack {
    // 속성
    int size; // 가방크기 (1 ~ 10)
    String brand; // 브랜드

    // 기능
    final void putItem() {
        System.out.println("가방에 물건을 넣습니다.");
    }

    void getItem() {

    }

    public BagPack(int size, String brand) {
        this.size = size;
        this.brand = brand;
    }
}

public class Person {
    String name;
    final String ssn;

    // 상수는 불변성, 유일성 -> static의 유일성, final의 불변성을 가지고 같이 사용한다
    static final String nation;// 상수

    final BagPack bagpack;


    static {
        nation = "대한민국";
    }

    // 매개변수(지역변수)에도 final을 붙혀 사용 할 수 있다. -> 값 변동 방지
    public Person(String name, String ssn, BagPack bagpack) {
        this.name = name;
        this.ssn = ssn;

        this.bagpack = bagpack;
    }
}

