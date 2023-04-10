package day10.song;

import day04.array.StringList;

import java.io.Serializable;
import java.util.Set;

public class Singer implements Serializable {

    private String name;
    private Set<String> songList; // 노래목록은 중복을 허용하지 않으니 Set

    public Singer() {
    }

    public Singer(String name, Set<String> songList) {
        this.name = name;
        this.songList = songList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSongList() {
        return songList;
    }

    public void setSongList(Set<String> songList) {
        this.songList = songList;
    }

    // 가수의 정보를 출력하는 기능
    public void info() {
        System.out.println("가수명: " + this.name);
        System.out.println("노래 목록: " + this.songList.toString());
    }
}
