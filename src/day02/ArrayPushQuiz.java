package day02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPushQuiz {

    public static void push(String newFood) {

        String[] temp = new String[wishFood.length+1];
        for (int i = 0; i < wishFood.length; i++) {
            temp[i] = wishFood[i];
        }

        temp[temp.length-1] = newFood;

        wishFood = temp;
        temp = null;

    }

//    public static void add() {
//
//    }
/*    public static String pop() {
        String[] temp;
        String lastFood = wishFood[wishFood.length-1];
        if(wishFood.length < 1) {
            temp = new String[0];
        }else {
            temp = new String[wishFood.length - 1];
        }

        for (int i = 0; i < temp.length; i++) {
            temp[i] = wishFood[i];
        }

        wishFood = temp;
        temp = null;

        return lastFood;
    }

    public static void del() {
        System.out.println("# 마지막에 추가한 음식이 삭제됩니다");
        System.out.println("# 삭제하시겠습니까? ( y / n )");

        System.out.print(">> ");
        switch (sc.nextLine()){
            case "y": System.out.println("삭제한 음식: " + pop()); break;
            case "n": System.out.println("종료합니다"); break;
        }
    }*/
    static String[] wishFood = new String[0];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        System.out.print("뭘 하시겠습니까\n 1.추가  2.삭제  3.목록보기 ");
//        int what = sc.nextInt();

//        switch (what) {
//            case 1: add();
////            case 2: del();
//            case 3: System.out.println("먹고 싶은 음식 리스트 : "+ Arrays.toString(wishFood));
//        }
        System.out.println("# 먹고 싶은 음식을 입력하세요!!");
        System.out.println("# 입력을 중지하려면 <그만>이라고 입력하세요.");
        while (true) {
            System.out.print(">> ");
            String newFood = sc.nextLine();

            if(newFood.equals("그만")) break;
            push(newFood);
        }
        System.out.println("먹고 싶은 음식 리스트 : "+ Arrays.toString(wishFood));
    }
}
