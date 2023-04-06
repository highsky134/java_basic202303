package day09.final_;

public class Main {


    public static void main(String[] args) {

        Person kim = new Person("김철수", "000111-1323244",
                new BagPack(5, "샘소나이트"));
        Person park = new Person("박영희", "991111-2222222",
                null);

        kim.name = "김출수";
//        kim.ssn = "123123124";

//        kim.bagpack = new BagPack(10,"기본");

    }
}
