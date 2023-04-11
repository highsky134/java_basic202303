package day12.lambda;

import day05.member.Gender;
import day05.member.Member;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static day05.member.Gender.*;
import static day12.lambda.Color.*;
import static day12.lambda.FilterApple.*;
import static day12.lambda.MappingApple.*;

public class Main {

    public static void main(String[] args) {
        // 사과 바구니 생성
        List<Apple> applesBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155,GREEN)
                , new Apple(120,RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        System.out.println("============= 녹색 사과 필터링 =============");
        List<Apple> greenApples = filterGreenApples(applesBasket);

        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }

        System.out.println("============= 노랑 사과 필터링 =============");

        List<Apple> colorApples = filterApplesByColor(applesBasket, YELLOW);
        for (Apple ca : colorApples) {
            System.out.println(ca);
        }

        System.out.println("============= 원하는 조건으로 필터링 =============");

        // 다형성의 원리로 ApplePredicate를 구현한 LightApplePredicate를 파라미터로 전달해
        // 그 함수를 호출해 사용함 -> Java의 콜백함수 우회 방법

        // 100g 이하 사과들
        List<Apple> filterApples = filterApples(applesBasket, new LightApplePredicate());

        for (Apple filterApple : filterApples) {
            System.out.println(filterApple);
        }
        // ----------------------------------------
        // 빨강 사과 필터링 -> 람다 변환
        List<Apple> filterApples1 = filterApples(applesBasket, apple -> apple.getColor() == RED);

        for (Apple apple : filterApples1) {
            System.out.println(apple);
        }

        System.out.println("============= 원하는 조건으로 필터링 =============");
        ApplePredicate newFilter = new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == GREEN && apple.getWeight() >= 100;
            }
        };
        List<Apple> filterApples2 = filterApples(applesBasket, newFilter);
        for (Apple apple : filterApples2) {
            System.out.println(apple);
        }

        System.out.println("============= 원하는 조건으로 필터링 =============");
        // 람다
        ApplePredicate newFilter1 = apple ->
                apple.getColor() == YELLOW && apple.getWeight() < 100;

        List<Apple> filterApples3 = filterApples(applesBasket, newFilter1);
        for (Apple apple : filterApples3) {
            System.out.println(apple);
        }

        System.out.println("============================");

        filter(applesBasket, apple -> apple.getWeight() >= 100
                && apple.getWeight() <= 150);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> filter = filter(numbers, n -> n % 2 == 0);
        System.out.println("filter = " + filter);

        List<String> wordList = List.of(
            "moments", "hello", "apple", "banana", "ace", "base", "zebra"
        );

        List<String> filter1 = filter(wordList, w -> w.length() == 5);
        System.out.println("filter1 = " + filter1);

        List<String> filter3 = wordList.stream().filter(w -> w.length() < 5)
                .collect(Collectors.toList());
        System.out.println("filter3 = " + filter3);



        // --------------------------- Mapping ---------------------

        List<Color> colorList = mappingAppleByColor(applesBasket);
        System.out.println("colorList = " + colorList);

        // 회원 정보에서 회원의 닉네임만 추출
        List<Member> memberList = List.of(
                new Member("abc@def.com","1234","홍길동",1, MALE, 25)
                ,new Member("abc@def.com","1234","둘리",2, MALE, 35)
                ,new Member("abc@def.com","1234","호동이",3, FEMALE, 45)
                ,new Member("abc@def.com","1234","유재석",4, FEMALE, 15)
                ,new Member("abc@def.com","1234","고길동",5, MALE, 19)

        );

        List<String> nameList = map(memberList, m -> m.memberName);
        System.out.println("nameList = " + nameList);


    }
}
