package day11.api.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime {

    public static void main(String[] args) {
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();

        // 현재 날짜 정보 얻기 (연, 월, 일)
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate);

        // 시, 분, 초
        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime = " + nowTime);

        // 연월일시분초
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("nowDateTime = " + nowDateTime);

        // 원하는 날짜 정보만 얻기
        int year = nowDateTime.getYear();
        System.out.println("year = " + year);

        // 특정 날짜 만들기
        LocalDateTime targetDate = LocalDateTime.of(2023, 5, 5, 9, 0, 0);
        System.out.println("targetDate = " + targetDate);

        // 날짜 연산
        // 도서 대여 시스템 빌린 날짜로 부터 3일 후가 반납일
        LocalDateTime rentalDate = LocalDateTime.now();
        LocalDateTime returnDate = rentalDate.plusDays(3);
        System.out.println("returnDate = " + returnDate);

        // plus 메소드의 리턴타입이 LocalDateTime 이어서 연속해서 사용 가능
        LocalDateTime targetDateTime = rentalDate.plusYears(1).plusMonths(2).plusDays(5).plusHours(5);
        System.out.println("targetDateTime = " + targetDateTime);

        // 사이 날짜 구하기
        LocalDate b = LocalDate.of(2019, 12, 28);
        LocalDate d = LocalDate.of(2023, 3, 10);

        long between = ChronoUnit.DAYS.between(b, d);
        System.out.println("between = " + between);


        // 날짜 포맷 바꾸기
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분");

        String dateString = nowDateTime.format(pattern);
        System.out.println("dateString = " + dateString);


    }
}
