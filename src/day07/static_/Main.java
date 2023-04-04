package day07.static_;

import juice.Utility;

import static day07.static_.Count.*;
import static java.lang.Math.*;
import static java.lang.System.*;
import static juice.Utility.*;
// static 필드와 메서드를 그냥 참조 가능


public class Main {
    public static void main(String[] args) {

        out.println(x); // 객체 생성전에도 참조 가능
        out.println(random()); // random 은 static

        m1(new Count());

        Count c1 = new Count();
        Count c2 = new Count();

        c2.m2();

        x = 10; // 스태틱 참조
        c2.y = 20;

        c2.x++;

        out.printf("c1 = x: %d, y: %d\n", c1.x, c1.y);
        out.printf("c2 = x: %d, y: %d\n", c2.x, c2.y);

        Calculator cal1 = new Calculator(); // kim
        Calculator cal2 = new Calculator(); // park

        cal1.color = "빨강";
        cal2.color = "초록"; //color는 바뀔수 있으니 static쓰면 안됨

        out.println("cal1 = " + cal1.color);

        Calculator.calcAreaCircle(5); //

        Calculator sharp = new Calculator();
        sharp.paint("노랑");

        makeLine();

        input("하하호호: ");




    }
}
