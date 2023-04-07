package day10.map;

import day09.music.Singer;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {

        HashMap<String, Object> map = new HashMap<>();

        // put(K, V): 데이터 추가
        map.put("지갑잔액", 5000);
        map.put("좋아하는 가수", new Singer("동방신기", null));
        map.put("저녁메뉴", "볶음밥");

        System.out.println(map.size());

        // get(key): 데이터 참조
//        Object dinner = map.get("저녁메뉴"); // -> 상위 타입으로 리턴이 온다면 다운캐스팅 해야함
        String dinner = (String) map.get("저녁메뉴");
        System.out.println("dinner = " + dinner);

//        Singer singer = (Singer) map.get("좋아하는 가수");
//        singer.info();

        System.out.println(map);
        map.put("저녁메뉴", "짬뽕"); // 존재하는 키를 다시 put하면 수정
        System.out.println(map);

        // 반복문 처리
        for (String key : map.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + map.get(key));
        }
    }
}
