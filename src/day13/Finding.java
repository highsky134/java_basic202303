package day13;

import static day13.Menu.*;

public class Finding {

    public static void main(String[] args) {

        // 메뉴 목록에서 채식주의가 먹을 수 있는 요리가 하나라도 존재하는가?
        boolean flag1 = menuList.stream()
                .anyMatch(d -> d.isVegetarian());
        System.out.println("flag1 = " + flag1);

        boolean flag2 = menuList.stream()
                .anyMatch(d -> d.getCalories() < 100);
        System.out.println("flag2 = " + flag2);

        //메뉴의 모든 요리가 100 칼로리 미만인가?
        boolean flag3 = menuList.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println("flag3 = " + flag3);

        // nonMatch: allMatch의 반대연산
    }
}
