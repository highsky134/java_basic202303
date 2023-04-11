package day12.inner;

public class Main {
    // 내부 클래스 (inner class)
    private static class SubCalculator implements Calculator{

        @Override
        public int operate(int n1, int n2) {
            return n1 - n2;
        }
    }

    public static void main(String[] args) {

        // 덧셈 계산기 쓰고싶다
        AddCalculator addCal = new AddCalculator();
        System.out.println(addCal.operate(30, 50));

        // 뺄셈 계산이 필요
        SubCalculator sub1 = new SubCalculator();
        System.out.println(sub1.operate(100, 40));

        // 곱셈도? 더빨리!! (익명 클래스) 이거 콜백함수처럼 보이기도 하네?
        // 필드 선언
        Calculator multiCal = new Calculator() {
            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };
        System.out.println(multiCal.operate(20,25));

        // 아니 나눗셈도 필요하네? (람다) : 인터페이스의 추상메서드가 '딱' 1개 일때만
        Calculator divCal = (n1, n2) -> n1 / n2;
        System.out.println(divCal.operate(50,10));


        // 애견카페 강아지
        Pet dog = new Pet() {

            @Override
            public void eat() {
                System.out.println("강아지는 개사료를 먹어요");
            }

            @Override
            public void play() {
                System.out.println("강아지는 마당에서 놀아요");
            }
        };



    }
}
