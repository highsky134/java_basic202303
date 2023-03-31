package day05;

public class Main {
    public static void main(String[] args) {
        Player parking = new Player("주차왕파킹");
        Player gondue = new Player("딸긔겅듀");
        Player noname = new Player();

        gondue.attack(parking);
        System.out.println("parking의 주소 : " + parking);
        System.out.println("gondue의 주소 : " + gondue);
//        System.out.println("주차왕 남은체력: " + parking.hp);


    }
}
