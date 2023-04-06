package day09.music;

import day04.array.StringList;

public class Singer {

    private String name;
    private StringList title;

    public Singer() {
    }

    public Singer(String name, StringList title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StringList getTitle() {
        return title;
    }

    public void setTitle(StringList title) {
        this.title = title;
    }

    // 가수의 정보를 출력하는 기능
    public void info() {
        System.out.println("가수명: " + this.name);
        System.out.println("노래 목록: " + this.title.toString());
    }
}
