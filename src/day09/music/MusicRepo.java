package day09.music;

import day04.array.StringList;

public class MusicRepo {

    private static Singer[] singers; // 가수들 모음
    private StringList list; //

    static {
        singers = new Singer[0];
    }

    public void addSong(String name, String title) {
        if (!isRegistered(name)) {
            inputNewSong(name, title);
        } else {
            addNewSong(name,title);
        }
    }


    // 첫번째 신규 노래 등록하기
    public void inputNewSong(String name, String title) { // title은 노래 제목이고

//        // 1. 가수 객체 생성
//        Singer s = new Singer();
//        // 2. 생성된 객체에 이름 셋팅
//        s.setName(name);
//        // 3. 생성된 가수 객체에 노래 목록 생성해서 셋팅
//        s.setTitle(new StringList());
//        // 4. 해당 노래 목록에 전달받은 노래 추가
//        s.getTitle().push(title);
        Singer s = new Singer(name, new StringList(title));
        // 5. 가수 배열에 가수 객체 추가
        push(s);
    }

    // 기존 가수 객체에 노래를 추가하는 기능
    public boolean addNewSong(String name, String title) {
        StringList songList = findSingerByName(name).getTitle();

        if(true) { //if ( ) // StringList includes() 사용
            songList.push(title);
            return true;
        }
        return false;
    }

    // 가입 되어있는 가수 인지 확인하는 기능
    public boolean isRegistered(String name) {
        return findSingerByName(name) != null;
    }

    // 가수명으로 노래 정보 검색 반환 기능
    public Singer findSingerByName(String name) {
        for (Singer singer : singers) {
            if (name.equals(singer.getName())) {
                return singer;
            }
        }
        return null;
    }

    // 특정 가수의 노래목록을 반환하는 기능
    public String[] getSongList(String name) {
        return findSingerByName(name).getTitle().getsArr();
    }

    // 등록된 가수의 수 반환
    public int count() {
        return singers.length;
    }

    public void push(Singer singer) {
        Singer[] temp = new Singer[singers.length+1];
        for (int i = 0; i < singers.length; i++) {
            temp[i] = singers[i];
        }
        temp[temp.length-1] = singer;
        singers = temp;
        temp = null;
    }
}
