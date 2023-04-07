package day10.generic;

import day04.array.StringList;
import day09.music.Singer;

public class Main {
    public static void main(String[] args) {

        AppleBasket ab = new AppleBasket();
        ab.setApple(new Apple());
        Apple apple = ab.getApple();

        BananaBasket bb = new BananaBasket();
        bb.setBanana(new Banana());

        Basket<Apple> apples = new Basket();
        apples.setFruit(new Apple());
//        apples.setFruit(new Banana()); // 사과 바구닌데 바나나가 들어가네?

        Apple fruit = apples.getFruit();
        Basket<Banana> bananas = new Basket<>();
//        bananas.setFruit(new Apple());
        bananas.setFruit(new Banana());

        Banana fruit1 = bananas.getFruit();

        MyList<String> sl = new MyList<>();

        sl.push("짜장면");
        sl.push("탕수육");
        System.out.println(sl);

        MyList<Integer> numbers = new MyList<>();


        MyList<Singer> singers = new MyList<>();
        singers.push(new Singer("소찬휘",new StringList("Tears")));

    }
}
