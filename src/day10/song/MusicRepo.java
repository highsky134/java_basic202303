package day10.song;

import day04.array.StringList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MusicRepo {

    // key: 가수의 이름, value: 가수 객체
    private static Map<String, Singer> singers; // 맵의 key는 중복 x
    private StringList list; //

    static {
        singers = new HashMap<>();
    }

    public void addSong(String name, String title) {
        if (!isRegistered(name)) {
            inputNewSong(name, title);
        } else {
            addNewSong(name,title);
        }
    }


    // 첫번째 신규 노래 등록하기
    public void inputNewSong(String name, String songName) {

        Singer singer = new Singer(name, new HashSet<>());
        singer.getSongList().add(songName);

        // 5. 가수 배열에 가수 객체 추가
        singers.put(singer.getName(), singer);
    }

    // 기존 가수 객체에 노래를 추가하는 기능
    public boolean addNewSong(String name, String songName) {
        Singer singer = findSingerByName(name);
        return singer.getSongList().add(songName);
    }

    // 가입 되어있는 가수 인지 확인하는 기능
    public boolean isRegistered(String name) {
        return singers.containsKey(name);
    }

    // 가수명으로 노래 정보 검색 반환 기능
    public Singer findSingerByName(String name) {
        return singers.get(name);
    }

    // 특정 가수의 노래목록을 반환하는 기능
    public Set<String> getSongList(String name) {
        return findSingerByName(name).getSongList();
    }

    // 등록된 가수의 수 반환
    public int count() {
        return singers.size();
    }
}
