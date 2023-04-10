package day10.song;

import day04.array.StringList;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MusicRepo {

    // key: 가수의 이름, value: 가수 객체
    private static Map<String, Singer> singers; // 맵의 key는 중복 x

    static {
        singers = new HashMap<>();
    }

    // 첫번째 신규 노래 등록하기
    public void inputNewSong(String name, String songName) {

        Singer singer = new Singer(name, new HashSet<>());
        singer.getSongList().add(songName);

        // 가수 맵에 가수 객체 추가
        singers.put(singer.getName(), singer);

        // 세이브파일에 저장
        autoSave();
    }

    // 기존 가수 객체에 노래를 추가하는 기능
    public boolean addNewSong(String name, String songName) {
        Singer singer = findSingerByName(name);
        boolean flag = singer.getSongList().add(songName);
        if (flag) autoSave();
        return flag;

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

    public void autoSave() {
        File f = new File("D:/music");
        if (!f.exists()) f.mkdir();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/music/m.sav"))) {
            oos.writeObject(singers);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadFile() {
        // 세이브파일이 존재한다면
        File f = new File("D:/music/m.sav");
        if (f.exists()) {
            // 로드해라
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                singers = (Map<String, Singer>) ois.readObject();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
