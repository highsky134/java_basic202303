package day13;

import day13.Dish;
import day13.Menu;
import juice.Utility;

import java.util.Comparator;
import java.util.stream.Collectors;

import static day13.Menu.*;
import static java.util.stream.Collectors.toList;
import static juice.Utility.*;

public class Sorting {

    public static void main(String[] args) {

        // stream의 정렬 sorted

        // 메뉴 목록중 칼로리가 낮은 순으로 정렬
        menuList.stream()
                .sorted(Comparator.comparing(d -> d.getName()))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s));

        makeLine();
        // 메뉴 목록중 이름으로 내림차 정렬 (zyx 순)
        menuList.stream()
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s));

        makeLine();
        // 칼로리가 300칼로리보다 큰 요리 중 앞에서 3개만 필터링
        menuList.stream()
                .filter(d -> d.getCalories() > 300)
                .sorted(Comparator.comparing(dish -> dish.getCalories()))
                .limit(3)
                .collect(toList())
                .forEach(d -> System.out.println(d));
    }
}
