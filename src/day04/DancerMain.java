package day04;

public class DancerMain {
    public static void main(String[] args) {
        Dancer kim = new Dancer();
        Dancer park = new Dancer("스트릿댄스");
        Dancer jang = new Dancer("장동견", "목각댄스", DanceLevel.PRO);

        System.out.println(park);
        System.out.println(kim);

        Singer song = new Singer();


        System.out.println(kim.introduce());
        System.out.println(park.introduce());
        System.out.println(jang.introduce());

        kim.dance();
        park.dance();
        jang.dance();
    }
}
