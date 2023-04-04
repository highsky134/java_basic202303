package day07.protec.pac2;

import day07.protec.pac1.A;

public class D extends A {
    D() {
        super(10); // super("zzz"); default접근 안됨
        f1 = 1;
//        f2 = 2; // 접근 안됨

        m1();
//        m2();
    }
}
