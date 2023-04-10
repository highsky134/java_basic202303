package day11.api.string;

public class StrBuilder {

    private static void makeString() {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 500000; i++) {
            s += "A";
        }
        long end = System.currentTimeMillis();

        System.out.println("스트링 총 소요 시간: " + (end-start) + "밀리초");
    }
    private static void makeStringBuilder() {
        long start = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < 500000; i++) {
            s.append("A");
        }
        long end = System.currentTimeMillis();

        System.out.println("빌더 총 소요 시간: " + (end-start) + "밀리초");
    }

    public static void main(String[] args) {
        makeStringBuilder();
        makeString();

        Integer a = 10; // 오토박싱
        Character c = 'A';

        // 기본 타입과 클래스 타입의 차이점 -> 기본값
        int i; // 기본값 0
        Integer j; // 기본값 null
    }
}
