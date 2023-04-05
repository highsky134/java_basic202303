package day08.poly.car;

import juice.Utility;

import static juice.Utility.makeLine;

public class Main {
    public static void main(String[] args) {
        CarShop shop = new CarShop();
        shop.runTest();

        makeLine();

        Driver park = new Driver();
        park.drive(new Tucson());

        makeLine();

        Mustang mustang = new Mustang();
        mustang.accelerate();
        mustang.powerSound();

        makeLine();

//        Mustang car = (Mustang) shop.exportCar(6000); // 타입 캐스팅
//        System.out.println("car = " + car);
//
//        car.powerSound();

        makeLine();

        Car car = shop.exportCar(6000);
        System.out.println(car instanceof Stinger);
        System.out.println(car instanceof Tucson);
        System.out.println(car instanceof Mustang);


    }
}
