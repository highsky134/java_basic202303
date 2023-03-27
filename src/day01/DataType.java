package day01;

public class DataType {

    public static void main(String[] args) {

        int a = 1000;

        //100; //메모리에 저장 (정수리터럴 4바이트 할당)
        // int a; //4바이트 공간 할당 이름을 a 부여
        // a = 10; // 미리저장된 100을 a에 복사

        // 실수 리터럴은 기본 8바이트 할당
        // float 4바이트 : 다운캐스팅
        float f1 = 1.23456789F;
        System.out.println("f1 = " + f1);

        double d1 = 1.2353253425632324;
        System.out.println("d1 = " + d1);

        // 논리타입
        boolean b1 = true;
        boolean b2 = false;

        // 문자 타입 : 한글자
        char c1 = 'A';
        System.out.println(c1 + 1);

        char c2 = 44032;
        System.out.println("c2 = " + c2);

        // 기본타입이 아니라 객체다
        String s = "hello";


    }
}
