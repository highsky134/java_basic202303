package day09.inter;

public interface Pet {

    // 인터페이스와 추상클래스의 차이

    // 필드를 선언할 수 없음

    // 생성자도 만들수 없다
    void eat();

    // 폭력적인 기능 Duck은 폭력적이지 않으니 기능을 따로 빼자! 새 클래스를 만들자!
//    public abstract void violent();
}
