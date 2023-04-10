package day10.song.selfsong;

import juice.Utility;

import java.util.HashSet;
import java.util.Set;

import static juice.Utility.*;

public class Artist {
    private String name; // 가수 이름

    private static Set<String> songList; // 노래 목록 -> 중복 허용 안되는 set 사용

    static {
        songList = new HashSet<>();
    }

    public Artist(String name, Set<String> songList) {
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

    public void info() {
        System.out.printf("# %s님의 노래 목록\n", name);
        makeLine();
        int i=0;
        for (String song : songList) {
            System.out.printf("* %d. %s",i+1, song);
            i++;
        }

    }
}
