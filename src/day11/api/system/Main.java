package day11.api.system;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // 운영체제의 현재 시간 읽기
        long time = System.currentTimeMillis();
        System.out.println("time = " + time);

        // 코드
        // time2 - time 으로 프로그램의 가동 시간을 구할수 있음
        long time2 = System.currentTimeMillis();
        System.out.println("time2 = " + time2);

        // 배열 카피
        int[] arr = {10,20,30};
        int[] copyArr = new int[arr.length];
        System.arraycopy(arr,0, copyArr, 0, arr.length);
        System.out.println(Arrays.toString(copyArr));

    }
}
