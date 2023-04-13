package day13;

import juice.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static day13.Dish.Type.*;
import static day13.Menu.*;
import static java.util.stream.Collectors.*;
import static juice.Utility.*;

public class Filtering {

    public static void main(String[] args) {

        // stream의 filter
        // 필터조건에 맞는 데이터들을 필터링

        // 메뉴목록 중에 채식주의자가 먹을 수 있는 요리를 알려주세요
        // 기존 List에서 원하는 조건으로 가져올때
//        List<Dish> vegeList = new ArrayList<>();
//        for (Dish dish : vegeList) {
//            if (dish.isVegetarian()) {
//                vegeList.add(dish);
//            }
//        }
        // 클래스를 따로 만들어 정의할때
//        List<Dish> filteredList = menuList.stream().filter(new VegePredicate())
//                .collect(Collectors.toList());

        // 내부 클래스 사용 방식
//        List<Dish> filteredList = menuList.stream().filter(new Predicate<Dish>() {
//                    @Override
//                    public boolean test(Dish dish) {
//                        return dish.isVegetarian();
//                    }
//                }).collect(Collectors.toList());

        List<Dish> filteredList = menuList.stream()
                .filter(dish -> dish.isVegetarian())
                .collect(toList());

        System.out.println("===== 채식주의자 요리 목록 =====");
        for (Dish dish : filteredList) {
            System.out.println(dish);
        }

        makeLine();

        filteredList.forEach(System.out::println);

        // 메뉴 목록중에 육류이면서 600 칼로리 미만인 요리 필터링
        menuList.stream()
                .filter(d -> d.getType() == MEAT && d.getCalories() < 600)
                .collect(toList()).forEach(d -> System.out.println(d));

        makeLine();

        menuList.stream()
                .filter(d -> d.getName().length() == 4)
                .collect(toList()).forEach(x -> System.out.println(x));

        makeLine();

        // 칼로리가 300칼로리보다 큰 요리 중 앞에서 3개만 필터링
        menuList.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3) // 앞에서 부터 3개 추출
                .collect(toList())
                .forEach(d -> System.out.println(d));

        makeLine();

        // 칼로리가 300칼로리보다 큰 요리 중 처음 2개는 제끼고 필터링
        menuList.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2) // 맨앞 2개 제외
                .collect(toList())
                .forEach(d -> System.out.println(d));

        makeLine();

        // 메뉴 목록에서 처음 등장하는 2개의 고기 요리를 필터링해서 리스트에 반환
        List<Dish> twoMeat = menuList.stream()
                .filter(d -> d.getType() == MEAT)
                .limit(2)
                .collect(toList());

        twoMeat.forEach(d -> System.out.println(d));

        List<Integer> numbers = List.of(6, 4, 1, 2, 1, 3, 3, 2, 4, 4, 5, 6);

        // 리스트에서 중복 제거 하기
        List<Integer> distinctedList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct().collect(toList());
        System.out.println("distinctedList = " + distinctedList);
    }
}
